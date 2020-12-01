package com.example.quiz_t_f_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the request queue using VolleySingleton class i.e. retrieve the object
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        // Set url
        url = "https://opentdb.com/api.php?amount=10&category=11&type=boolean";
        JsonObjectRequest filmsJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("FILMS", response.toString());
                Toast.makeText(getApplicationContext(), "Successful Call", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", error.getMessage());
                Toast.makeText(getApplicationContext(), "Unsuccessful Call", Toast.LENGTH_SHORT).show();
            }
        });

        mRequestQueue.add(filmsJsonObjectRequest);
    }
}