package test.app.paaya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class reward extends AppCompatActivity  implements   ExampleDialoglost.ExampleDialoglostListener , DatePickerDialog.OnDateSetListener {
     EditText txtManny;
    SharedPreferences shareP;
    String txt;
    private  static  final  String Date_key="keyDate";
    private  static  final  String reward_key="keyReward";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        txtManny=findViewById(R.id.txtManny);
        shareP = getSharedPreferences("myShareP", MODE_PRIVATE );
    }

    public void set(View view) {
        txt=txtManny.getText().toString();
        if (txt.isEmpty()){
            txtManny.setError("required champ");
            txtManny.requestFocus();
                 }
        else{
            SharedPreferences.Editor editor  = shareP.edit();
            editor.putString(reward_key, txt);
            editor.apply();
            openDialog();

    }}

    public void skip(View view) {
        Intent in = new Intent(this, verifLost.class);
        startActivity(in);
    }
    public void openDialog() {
        ExampleDialoglost dialog = new ExampleDialoglost();
        dialog.show(getSupportFragmentManager(), "example dialog");
    }
    @Override
    public void onYesClicked() {
        showDatePickerDialog();
    }
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date =  month + "/" + dayOfMonth + "/" + year;
        /* dateText.setText(date);*/
        SharedPreferences.Editor editor  = shareP.edit();
        editor.putString(Date_key, date);
        editor.apply();
        Intent in = new Intent(this, verifLost.class);
        startActivity(in);
    }

}
