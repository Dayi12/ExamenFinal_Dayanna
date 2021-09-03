package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenfinal.holder.HolderJournals;
import com.example.examenfinal.models.Journals;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String Ruta = "https://revistas.uteq.edu.ec/ws/journals.php";
    RequestQueue requestQueue;
    PlaceHolderView listView;
    private ArrayList<Journals> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        revistasResquest(Ruta);
        listView=findViewById(R.id.recycler);
    }


    public void revistasResquest(String Ruta) {
        JsonArrayRequest json = new JsonArrayRequest(Request.Method.GET,
                Ruta, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        lista = new ArrayList<>();
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            try {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                String journal_id = objeto.getString("journal_id");
                                String portada = objeto.getString("portada");
                                String abbreviation = objeto.getString("abbreviation");
                                String description = objeto.getString("description");
                                String journalThumbnail = objeto.getString("journalThumbnail");
                                String name = objeto.getString("name");
                                Journals elemento = new Journals(journal_id, portada, abbreviation, description, journalThumbnail, name);
                                lista.add(elemento);
                                listView.addView(new HolderJournals(getApplicationContext(),elemento));
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