package test.app.paaya;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    SharedPreferences shareP;
    private static final String lostKeyy = "lostkeyy";
    private  static final String foundKeyy = "foundkeyy";
     String foundd ,lostt;
    private AppBarConfiguration mAppBarConfiguration;
            FirebaseUser currentUserr;
            FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        shareP=getSharedPreferences("myShareP", MODE_PRIVATE );

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        //initialitation
        mAuth=FirebaseAuth.getInstance();
        currentUserr=mAuth.getCurrentUser();
        updateNavHeader();

       navigationView.getMenu().findItem(R.id.logout).setOnMenuItemClickListener(menuItem -> {
            logout();
            return true;
        });
      /* navigationView.getMenu().findItem(R.id.upDayteProfile).setOnMenuItemClickListener(menuItem -> {
           Intent in = new Intent(this, update.class);
           startActivity(in);
           return true;
       });*/
        navigationView.getMenu().findItem(R.id.facebook).setOnMenuItemClickListener(menuItem -> {
            Intent in = new Intent(Intent.ACTION_VIEW);
            in.setData(Uri.parse("https://www.facebook.com/profile.php?id=100004487568645"));
            startActivity(in);
            return true;
        });
        navigationView.getMenu().findItem(R.id.share).setOnMenuItemClickListener(menuItem -> {
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String Apkpath = api.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-arhive");
            intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File(Apkpath)));
            startActivity(Intent.createChooser(intent, "ShareVia"));
            return true;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void test(View view) {
        lostt="lost";
        SharedPreferences.Editor editor  = shareP.edit();
        editor.putString(lostKeyy ,  lostt);
        editor.apply();
            Intent in = new Intent(this, lost_somthing.class);
            startActivity(in);
        }


        public void tests (View view){
           foundd="found";
            SharedPreferences.Editor editor  = shareP.edit();
            editor.putString(foundKeyy,  foundd);
            editor.apply();
            Intent inn = new Intent(this, found_somthing.class);
            startActivity(inn);
        }


      public  void  updateNavHeader(){
          NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView= navigationView.getHeaderView(0);
          TextView name= headerView.findViewById(R.id.name);
          TextView email= headerView.findViewById(R.id.email);
          ImageView img= headerView.findViewById(R.id.imageView);
          if (currentUserr != null) {
          name.setText(currentUserr.getDisplayName());
          email.setText(currentUserr.getEmail());
          Glide.with(this).load(currentUserr.getPhotoUrl()).into(img);}
      }


   /* @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();
        if (id==R.id.logout)
        {
          FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
            mFirebaseAuth.signOut();
            Intent in=new Intent(getApplicationContext(),login.class);
            startActivity(in);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    public void logout(){
        //FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Intent in=new Intent(getApplicationContext(),login.class);
        startActivity(in);
        finish();
    }
}