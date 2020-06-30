package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cunoraz.gifview.library.GifView;
import com.example.myapplication.R;
import com.example.myapplication.bitcoin.BitCoinActivity;
import com.example.myapplication.corona.MainActivity;
import com.example.myapplication.entertainment.EntertainmentActivity;
import com.example.myapplication.science.ScienceActivity;
import com.example.myapplication.sport.SportActivity;
import com.example.myapplication.technology.TechnologyActivity;

public class First extends AppCompatActivity {
LinearLayout corona,sport,technology,bitcoin,science,entertainment,firstLinear;
GifView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
         corona=findViewById(R.id.corona_id);
         science=findViewById(R.id.science_id);
         entertainment=findViewById(R.id.entertainment_id);
         bitcoin=findViewById(R.id.bitcoin_id);
         technology=findViewById(R.id.technology_id);
         sport=findViewById(R.id.sport_id);
         corona.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                 startActivity(intent);
             }
         });
          sport.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(getApplicationContext(), SportActivity.class);
                  startActivity(intent);
              }
          });
          technology.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(getApplicationContext(), TechnologyActivity.class);
                  startActivity(intent);
              }
          });
          bitcoin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(getApplicationContext(), BitCoinActivity.class);
                  startActivity(intent);
              }
          });
          science.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(getApplicationContext(), ScienceActivity.class);
                  startActivity(intent);
              }
          });
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), EntertainmentActivity.class);
                startActivity(intent1);
            }
        });

    }
}
