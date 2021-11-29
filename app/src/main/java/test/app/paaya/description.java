package test.app.paaya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class description extends AppCompatActivity implements  ExampleDialog.ExampleDialogListener  , DatePickerDialog.OnDateSetListener {
        SharedPreferences shareP;
        TextView dateText;
        Button button;
        TextView txt;
        String question;
        private  static  final  String Date_key="keyDate";
        private  static  final  String question_key="keyQuestion";

@Override
protected void onCreate(Bundle savedInstanceState) {
        shareP = getSharedPreferences("myShareP", MODE_PRIVATE );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discription);
         txt = findViewById(R.id.txt);
        button = (Button) findViewById(R.id.mm);
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
          question=txt.getText().toString();
          if (question.isEmpty()){
                  txt.setError("required champ");
                  txt.requestFocus();
          }
          else{
                  SharedPreferences.Editor editor  = shareP.edit();
                  editor.putString(question_key, question);
                  editor.apply();
        openDialog();
        }}
        });
        }
public void openDialog() {
        ExampleDialog dialog = new ExampleDialog();
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
        Intent in = new Intent(this, verif.class);
        startActivity(in);
        }

    public void cancul(View view) {
        txt.setText("");
    }
}
