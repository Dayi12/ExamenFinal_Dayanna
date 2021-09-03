package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenfinal.holder.HolderIssues;
import com.example.examenfinal.holder.HolderPubs;
import com.example.examenfinal.models.Volumen;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PubsActivity extends AppCompatActivity {
    String i_id;
    String Ruta_Pubs="https://revistas.uteq.edu.ec/ws/pubs.php";
    PlaceHolderView pubsHolder;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubs);
        requestQueue = Volley.newRequestQueue(this);
        i_id=getIntent().getExtras().getString("i_id");
        pubsHolder=findViewById(R.id.pubsHolder);
        pubsRequest(i_id,Ruta_Pubs);
    }
    private void pubsRequest(String i_id, String Ruta) {
        Ruta += "?i_id=" + i_id;
        JsonArrayRequest json = new JsonArrayRequest(Request.Method.GET,
                Ruta, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            try {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                String section = objeto.getString("section");
                                String publication_id = objeto.getString("publication_id");
                                String title = objeto.getString("title");
                                String doi = objeto.getString("doi");
                                String abstrac = objeto.getString("abstract");
                                String date_published = objeto.getString("date_published");
                                String submission_id = objeto.getString("submission_id");
                                String section_id = objeto.getString("section_id");
                                String seq = objeto.getString("seq");
                                String galeys = objeto.getString("galeys");
                                String keywords = objeto.getString("keywords");
                                String authors = objeto.getString("authors");
                                Volumen elemento = new Volumen(section, publication_id, title, doi, abstrac, date_published, submission_id, section_id, seq,galeys,keywords,authors);
                                pubsHolder.addView(new HolderPubs(getApplicationContext(),elemento));
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