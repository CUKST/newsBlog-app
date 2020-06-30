package com.example.myapplication.entertainment;

import android.os.AsyncTask;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;
import com.example.myapplication.sport.WebForSport;

public class WebForEntertainment extends AppCompatActivity {
    public static String url="";
        com.mikhaellopez.circularfillableloaders.CircularFillableLoaders rs;
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_for_entertainment);
        rs=findViewById(R.id.entertainment_webProgress);
        wb=findViewById(R.id.entertainment_web);
        wb.getSettings().setJavaScriptEnabled(true);
        this.setTitle("Entertainment");
        new Task().execute();

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
            rs.setVisibility(View.VISIBLE);
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
                    rs.setVisibility(View.GONE);

                }
            });
            return null;
        }
    }

}
