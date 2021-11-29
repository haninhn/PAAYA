package test.app.paaya;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class Laptoplost extends AppCompatActivity {

    SharedPreferences shareP;
    private  static  final  String Sub_category_key="keySub";
    GridView gridView;

    String[] itemsNames = {"Asus","Dell","Lenovo","hp","Apple","Samsung","Acer","Any Laptop","other"};
    int[] itemsImages = {R.drawable.ic_baseline_laptop_24,R.drawable.ic_baseline_laptop_24,R.drawable.ic_baseline_laptop_24,
            R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24,R.drawable.ic_baseline_laptop_24,
            R.drawable.ic_baseline_laptop_24 ,R.drawable.ic_baseline_laptop_24,R.drawable.others };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptoplost);
        shareP = getSharedPreferences("myShareP", MODE_PRIVATE );
        //finding listview
        gridView = findViewById(R.id.gridView3);

        Laptoplost.CustomAdapter customAdapter = new Laptoplost.CustomAdapter();
        gridView.setAdapter((ListAdapter) customAdapter);
        gridView.setOnItemClickListener(new  AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int id, long l) {
                SharedPreferences.Editor editor  = shareP.edit();
                editor.putString(Sub_category_key, itemsNames[id]);
                editor.apply();
                Toast.makeText(getApplicationContext(),itemsNames[id],Toast.LENGTH_SHORT).show();
                Intent intent  =new Intent(getApplicationContext(), locationlost.class);
                startActivity(intent);
               /* if( id == 0) {}
                if( id == 1) {  }
                if(id ==2){ }
                if(id ==3){}
                if(id ==4){ }
                if(id ==5){ }
                if(id ==6){}
                if(id ==7){}
                if(id ==8){}
                if(id ==9){}*/

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

            @SuppressLint({"InflateParams", "ViewHolder"}) View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
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
