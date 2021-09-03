package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenfinal.holder.HolderIssues;
import com.example.examenfinal.models.Issues;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class IssuesActivity extends AppCompatActivity {
    String j_id;
    String Ruta_Issues="https://revistas.uteq.edu.ec/ws/issues.php";
    PlaceHolderView issuesHolder;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issues);
        requestQueue = Volley.newRequestQueue(this);
        j_id=getIntent().getExtras().getString("j_id");
        issuesHolder=findViewById(R.id.issuesHolder);
        issuesRequest(j_id,Ruta_Issues);
    }

    private void issuesRequest(String j_id, String Ruta) {
        Ruta += "?j_id=" + j_id;
        JsonArrayRequest json = new JsonArrayRequest(Request.Method.GET,
                Ruta, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            try {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                String issue_id = objeto.getString("issue_id");
                                String volume = objeto.getString("volume");
                                String number = objeto.getString("number");
                                String year = objeto.getString("year");
                                String date_published = objeto.getString("date_published");
                                String title = objeto.getString("title");
                                String doi = objeto.getString("doi");
                                String cover = objeto.getString("cover");
                                Issues elemento = new Issues(issue_id, volume, number, year, date_published, title, doi, cover);
                                issuesHolder.addView(new HolderIssues(getApplicationContext(),elemento));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(json);
    }
}