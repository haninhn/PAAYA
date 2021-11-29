package test.app.paaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class locationlost extends AppCompatActivity {
    SharedPreferences shareP;
    private  static  final  String Location_key="keyLocation";
    EditText Text;

    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationlost);
        Text=findViewById(R.id.descriptLocation);
        shareP = getSharedPreferences("myShareP", MODE_PRIVATE );


    }




    public void cancel(View view) {
        Text.setText("");
    }

    public void send(View view) {
        txt=Text.getText().toString();
        if(txt.isEmpty()){
            Text.setError("required champ");
            Text.requestFocus();
        }
        else {
            SharedPreferences.Editor editor  = shareP.edit();
            editor.putString(Location_key, txt);
            editor.apply();
            Intent in = new Intent(this, colorlost.class);
            startActivity(in);}
    }

}