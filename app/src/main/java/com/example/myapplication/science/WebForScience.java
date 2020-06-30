package com.example.myapplication.science;

import android.os.AsyncTask;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;
import com.example.myapplication.sport.WebForSport;

public class WebForScience extends AppCompatActivity {
    public static String url="";
    ProgressBar progressBar;
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_for_science);
        progressBar=findViewById(R.id.science_webProgress);
        wb=findViewById(R.id.science_web);
        wb.getSettings().setJavaScriptEnabled(true);
        this.setTitle("Science");
        new  Task().execute();

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
