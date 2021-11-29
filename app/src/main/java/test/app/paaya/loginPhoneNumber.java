package test.app.paaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
public class loginPhoneNumber extends AppCompatActivity {
    TextInputLayout regPhoneNo;
    ScrollView scrollView;
    String val;
    String checkspaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_phone_number);
        scrollView = findViewById(R.id.signup_3rd_screen_scroll_view);
        regPhoneNo=findViewById(R.id.mm);
    }

    public void cancel(View view) {
        Intent inIntent  =new Intent(this, login.class);
        startActivity(inIntent);
    }


    public void sing(View view) {
        val = (Objects.requireNonNull(regPhoneNo.getEditText())).getText().toString().trim();
        checkspaces = "\\A\\w{1,8}\\z";

          if (val.isEmpty()) {
            regPhoneNo.setError("Enter valid phone number");}
            else if (!val.matches(checkspaces)) {
              regPhoneNo.setError("No White spaces are allowed!");}
      /* if(!validatePhoneNumber()){
             return;//Get the Phone No from phone no field in String
           }

        validatePhoneNumber();*/
    else{
        Intent intent = new Intent(getApplicationContext(), codeverif.class);
        intent.putExtra("phoneNo", val);
        startActivity(intent);}
        }



  /*  private boolean validatePhoneNumber() {
        val = (regPhoneNo.getEditText()).getText().toString().trim();

         checkspaces = "\\A\\w{1,8}\\z";

        if (val.isEmpty()) {
            regPhoneNo.setError("Enter valid phone number");
            return false;
        } else if (!val.matches(checkspaces)) {
            regPhoneNo.setError("No White spaces are allowed!");
            return false;
        } else {
            regPhoneNo.setError(null);
        //    regPhoneNo.setErrorEnabled(false);
            return true;
        }

    }*/
}