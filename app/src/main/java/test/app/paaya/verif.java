package test.app.paaya;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class verif extends AppCompatActivity {
    SharedPreferences shareP;
    // SharedPreferences sharePP;
    TextView main_category;
    TextView sub_category;
    TextView color;
    TextView date, datetxt;
    TextView question;
    TextView location;
    String mainCategory, subCategory, objectColor, objectDate, userQuestion, objectFoundLocation, num;

    /*  private static final String lost = "lostkey";
      private  static final String found = "foundkey";*/
    private static final String Location_key = "keyLocation";
    private static final String main_category_key = "key";
    private static final String Sub_category_key = "keySub";
    private static final String color_key = "keyColor";
    private static final String Date_key = "keyDate";
    private static final String question_key = "keyQuestion";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verif);
        main_category = findViewById(R.id.main_Categ);
        sub_category = findViewById(R.id.Sub_Categ);
        color = findViewById(R.id.color);
        date = findViewById(R.id.date);
        question = findViewById(R.id.QR);
        location = findViewById(R.id.location);
        datetxt = findViewById(R.id.dateText);


        shareP = getSharedPreferences("myShareP", MODE_PRIVATE);
        // sharePP = getSharedPreferences("mySharePP", MODE_PRIVATE );

        // string VAR get data
        mainCategory = shareP.getString(main_category_key, null);
        subCategory = shareP.getString(Sub_category_key, null);
        objectFoundLocation = shareP.getString(Location_key, null);
        objectColor = shareP.getString(color_key, null);
        objectDate = shareP.getString(Date_key, null);
        userQuestion = shareP.getString(question_key, null);
        //set Data to TextView
        main_category.setText(mainCategory);
        sub_category.setText(subCategory);
        location.setText(objectFoundLocation);
        color.setText(objectColor);
        date.setText(objectDate);
        question.setText(userQuestion);

        //recuperate number
        num = shareP.getString("number", null);
        //TYpe data
      /* sharePP.getString(found, null);
       sharePP.getString(lost, null);*/

    }

    public void submit(View view) {
        if (num != null) {
            storeNewUsersData();
        } else {
            Toast.makeText(this, "no current user", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(getApplicationContext(), login.class);
            startActivity(in);
            finish();
        }

    }

    private void storeNewUsersData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
         //if(  found != null){
        DatabaseReference reference = database.getReference("object found");
        //Create helperclass reference and store data using firebase
        foundHelperClass addNewUser = new foundHelperClass(mainCategory, subCategory, objectColor, objectDate, userQuestion, objectFoundLocation, num);
        // emailTxt = emaile.getText().toString();
        reference.child(num).setValue(addNewUser);
    /*}
        else if(lost != null){

            DatabaseReference reference = database.getReference("object lost");
            //Create helperclass reference and store data using firebase
            LostHelperClass addNewUser = new LostHelperClass(mainCategory, subCategory, objectColor, objectDate,userQuestion,objectFoundLocation, num);
            // emailTxt = emaile.getText().toString();
            reference.child(num).setValue(addNewUser);
        }*/

        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();
                    }
}