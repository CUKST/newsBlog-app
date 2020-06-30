package com.example.myapplication.bitcoin;

import android.os.AsyncTask;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;
import com.example.myapplication.technology.WebForTech;

public class WebForBitCoin extends AppCompatActivity {
    public static String url="";
    ProgressBar progressBar;
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_for_bit_coin);
        progressBar=findViewById(R.id.bitcoin_webProgress);
        wb=findViewById(R.id.bitcoin_web);
        wb.getSettings().setJavaScriptEnabled(true);

        new Task().execute();

        this.setTitle("Bit Coin");

    }

    @Override
    public void onBackPressed() {
        if(wb.canGoBack()){
            wb.goBack();
        }
        else
        super.onBackPressed();
    }

    public class Task extends AsyncTask<Void,Void,Void> {
        public Task() {
        }

        @Override
        public void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            wb.setVisibility(View.GONE);

        }

        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        public Void doInBackground(Void... voids) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    wb.loadUrl(url);
                    wb.setWebViewClient(new WebViewClient());
                    wb.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);

                }
            });
            return null;
        }
    }

}