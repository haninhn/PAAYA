package test.app.paaya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class compete extends AppCompatActivity {
    SharedPreferences shareP;
    ImageView imgg;
    EditText namee, emaile, PhoneNumber, address;
    String numTxt,emailTxt,adTxt,nameTxt,gender;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_compte);
        shareP=getSharedPreferences("myShareP", MODE_PRIVATE );

        imgg = findViewById(R.id.imgg);
        namee = findViewById(R.id.name1);
        emaile = findViewById(R.id.email1);
        PhoneNumber = findViewById(R.id.num1);
        address = findViewById(R.id.ad1);
        radioGroup = findViewById(R.id.radio_group);
       FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            emaile.setText(currentUser.getEmail());
        }
    }


    public void SING(View view) {
        //Check validation
       numTxt =PhoneNumber.getText().toString();
       emailTxt = emaile.getText().toString();
       adTxt =address.getText().toString();
        nameTxt =namee.getText().toString();
        gender= String.valueOf(radioGroup.getCheckedRadioButtonId());
          if(nameTxt.isEmpty()){
            namee.setError("required champ");
            namee.requestFocus();}
            else if (emailTxt.isEmpty()) {
                emaile.setError("required champ");
                emaile.requestFocus();}
                else if(numTxt.length() != 8){
                    PhoneNumber.setError(" verif Number ");
                    PhoneNumber.requestFocus();}
                      else  if(adTxt.isEmpty()){
                          address.setError("required champ");
                          address.requestFocus();}
                             else  if (radioGroup.getCheckedRadioButtonId() == -1) {
                                Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();}

           else{
            //Validation succeeded and now move to next screen
              SharedPreferences.Editor editor  = shareP.edit();
              editor.putString("number",  numTxt);
              editor.putString("email",  emailTxt);
              editor.putString("address", adTxt );
              editor.putString("name", nameTxt);
              editor.apply();
             Intent in = new Intent(getApplicationContext(), MainActivity.class);
              storeNewUsersData();
            //Pass all fields to the next activity
            startActivity(in);
              finish();
        }}

    private void storeNewUsersData() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Users");

        //Create helperclass reference and store data using firebase
        UserHelperClass addNewUser = new UserHelperClass(nameTxt, emailTxt, numTxt, adTxt, gender);
       // emailTxt = emaile.getText().toString();
        reference.child(numTxt).setValue(addNewUser);

        //We will also create a Session here in next videos to keep the user logged In
        Toast.makeText(this,"data saved", Toast.LENGTH_SHORT).show();
                                  }


}