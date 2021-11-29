package test.app.paaya;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class lost_somthing  extends Activity {
    GridView gridView;
    SharedPreferences shareP;
    private  static  final  String main_category_key="key";
    String[] itemsNames = {"Laptops","Phones","Watches","Electronics","Keys","Cards","Documents","Bags","Money","Jewellery","Glasses","Garments","Shoes","Cosmetics","Pets","Umbrella","Human","Others"};
    int[] itemsImages = {R.drawable.ic_baseline_laptop_24,R.drawable.ic_baseline_phone_android_24,R.drawable.ic_outline_watch_24,R.drawable.elec,R.drawable.key22,R.drawable.card,R.drawable.doc2 ,R.drawable.backpack,R.drawable.money,R.drawable.necklace,
            R.drawable.sunglasses,R.drawable.clothes,R.drawable.sneakers,R.drawable.cosmetics,R.drawable.pets,R.drawable.umbrella,R.drawable.ic_outline_emoji_people_24,R.drawable.other };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lost);
        shareP = getSharedPreferences("myShareP", MODE_PRIVATE );
        //finding listview
        gridView = findViewById(R.id.gridView2);
        lost_somthing.CustomAdapter customAdapter = new lost_somthing.CustomAdapter();
        gridView.setAdapter((ListAdapter) customAdapter);
        gridView.setOnItemClickListener(new  AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int id, long l) {
                Toast.makeText(getApplicationContext(),itemsNames[id],Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor  = shareP.edit();
                if( id == 0)
                { editor.putString(main_category_key, itemsNames[0]);
                    editor.apply();
                   /* Intent  intent  =new Intent(getApplicationContext(), laptop.class);
                    startActivity(intent);}*/
                    Intent  intent  =new Intent(getApplicationContext(), Laptoplost.class);
                    startActivity(intent);}
                if( id == 1)
                {        /*  editor.putString(main_category_key, itemsNames[1]);
                          editor.apply();
                   Intent  intent  =new Intent(getApplicationContext(), phones.class);
                    startActivity(intent);*/}
                if(id ==2){
                    Intent  intent  =new Intent(getApplicationContext(), watches.class);
                    startActivity(intent);}
                if(id ==3){  Intent  intent  =new Intent(getApplicationContext(), electronics.class);
                    startActivity(intent);}
                if(id ==4){ Intent  intent  =new Intent(getApplicationContext(), keys.class);
                    startActivity(intent);}
                if(id ==5){  Intent  intent  =new Intent(getApplicationContext(), cards.class);
                    startActivity(intent);}
                if(id ==6){ Intent  intent  =new Intent(getApplicationContext(), documents.class);
                    startActivity(intent);}
                if(id ==7){ Intent  intent  =new Intent(getApplicationContext(), bages.class);
                    startActivity(intent);}
                if(id ==8){Intent  intent  =new Intent(getApplicationContext(), money.class);
                    startActivity(intent);}
                if(id ==9){Intent  intent  =new Intent(getApplicationContext(), jewellery.class);
                    startActivity(intent);}
                if(id ==10){Intent  intent  =new Intent(getApplicationContext(), glasses.class);
                    startActivity(intent);}
                if(id ==11){Intent  intent  =new Intent(getApplicationContext(), garments.class);
                    startActivity(intent);}
                if(id ==12){Intent  intent  =new Intent(getApplicationContext(), shoes.class);
                    startActivity(intent);}
                if(id ==13){Intent  intent  =new Intent(getApplicationContext(), cosmetics.class);
                    startActivity(intent);}
                if(id ==14){Intent  intent  =new Intent(getApplicationContext(), pets.class);
                    startActivity(intent);}
                if(id ==15){Intent  intent  =new Intent(getApplicationContext(), umbrella.class);
                    startActivity(intent);}
                if(id ==16){Intent  intent  =new Intent(getApplicationContext(), human.class);
                    startActivity(intent);}
                if(id ==17){Intent  intent  =new Intent(getApplicationContext(), other.class);
                    startActivity(intent);}




            }

        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return itemsImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View View, ViewGroup parent) {

            @SuppressLint("InflateParams") View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name;
            name = view1.findViewById(R.id.item);
            ImageView image = view1.findViewById(R.id.image);

            name.setText(itemsNames[i]);
            image.setImageResource(itemsImages[i]);
            return view1;



        }
    }
}
