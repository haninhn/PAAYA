package test.app.paaya;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class color extends AppCompatActivity {
    SharedPreferences shareP;

    private  static  final  String color_key="keyColor";
    ImageView imageView;
    TextView mColorValues;
    View mColorshow;
    private static final String lostKeyy = "lostkeyy";
    private  static final String foundKeyy = "foundkeyy";
    String lostSomthing;
    String foundSomthing;
    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
            shareP = getSharedPreferences("myShareP", MODE_PRIVATE );


            imageView=findViewById(R.id.colorPicker);
            mColorValues=findViewById(R.id.displayValues);
            mColorshow=findViewById(R.id.displayColor);
            imageView.setDrawingCacheEnabled(true);
            imageView.buildDrawingCache(true);
            imageView.setOnTouchListener((v, event) -> {
                if ((event.getAction()== MotionEvent.ACTION_DOWN)||(event.getAction()== MotionEvent.ACTION_MOVE)){
                    Bitmap bitmap= imageView.getDrawingCache();
                    int pixel= bitmap.getPixel((int)event.getX(), (int)event.getY() );
                    int r= Color.red(pixel);
                    int g=Color.green(pixel);
                    int b=Color.blue(pixel);
                    String hex="#"+ Integer.toHexString(pixel);
                    mColorshow.setBackgroundColor(Color.rgb(r,g,b));
                    mColorValues.setText("RGB: "+r+", "+g+", "+b+ "\n Hex: "+hex);
                }
                return true;
            });
        lostSomthing= shareP.getString(lostKeyy,null);
        foundSomthing= shareP.getString(foundKeyy,null);
        }


        public void next(View view) {
            SharedPreferences.Editor editor  = shareP.edit();
            editor.putString(color_key, String.valueOf(mColorValues));
            editor.apply();
            /*if(lostSomthing != null){
                Intent in = new Intent(this, reward.class);
                startActivity(in);}*/
          //  if ( foundSomthing != null){
            Intent in = new Intent(this, description.class);
            startActivity(in);}
        //    }

        }