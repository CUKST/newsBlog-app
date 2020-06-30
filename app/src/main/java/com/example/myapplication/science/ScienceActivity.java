package com.example.myapplication.science;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.example.myapplication.sport.Sport;
import com.example.myapplication.sport.SportActivity;
import com.example.myapplication.sport.SportAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ScienceActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    String url;
    ArrayList<Science> newArrayList1=new ArrayList<Science>();
    com.mikhaellopez.circularfillableloaders.CircularFillableLoaders rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        recyclerView=findViewById(R.id.recycler_science);
        rs=findViewById(R.id.progress_science);
        this.setTitle("Science");
        new Task().execute();

    }
    public class Task extends AsyncTask<Void,Void,Void> {
        public Task() {
        }

        @Override
        protected void onPreExecute() {
           rs.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            url="https://newsapi.org/v2/top-headlines?apiKey=0c0ffccee12c40c893e8ee40ba03f07b&category=science";

            RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
            JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray articles=response.getJSONArray("articles");
                        for(int i=0;i<articles.length();i++){
                            JSONObject jsonObject=articles.getJSONObject(i);
                         Science sport=new Science(
                                    jsonObject.getString("publishedAt"),jsonObject.getString("urlToImage"),
                                    jsonObject.getString("author"),jsonObject.getString("title"),jsonObject.getString("description"),
                                    jsonObject.getString("url")
                            );
                            newArrayList1.add(sport);
                        }
                    } catch (JSONException e) {
                        Log.e("json error",e.getMessage());
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           ScienceAdapter adapter=new ScienceAdapter(newArrayList1,getApplicationContext());
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                            recyclerView.setVisibility(View.VISIBLE);
                           rs.setVisibility(View.GONE);

                        }
                    });
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Volley Ero",error.getMessage());
                }
            });
            getJsonObjectRequest(jsonObjectRequest).setRetryPolicy(new RetryPolicy() {
                @Override
                public int getCurrentTimeout() {
                    return 50000;
                }

                @Override
                public int getCurrentRetryCount() {
                    return 50000;
                }

                @Override
                public void retry(VolleyError error) throws VolleyError {

                }
            });
            queue.add(getJsonObjectRequest(jsonObjectRequest));


            return null;
        }
    }
    private JsonObjectRequest getJsonObjectRequest(JsonObjectRequest jsonObjectRequest) {
        return jsonObjectRequest;
    }

}
