package com.example.quiz_t_f_app.model;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.quiz_t_f_app.R;
import com.example.quiz_t_f_app.VolleySingleton;
import com.example.quiz_t_f_app.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    Context mContext;
    private RequestQueue mRequestQueue;
    private String url;

    public QuizManager(Context context) {
        mContext = context;
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        url = "https://opentdb.com/api.php?amount=10&category=11&type=boolean";
    }

    public void getQuizQuestions(final Activity activity) { // if you want to modify the activity, you have to pass it into the function

        final List<QuizQuestion> quizQuestions = new ArrayList<>();

        JsonObjectRequest filmsJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("FILMS", response.toString());
                Toast.makeText(mContext, "Successful Call", Toast.LENGTH_SHORT).show();

                try {
                    JSONArray results = response.getJSONArray("results");
                    CardStackView mCardStackView;
                    for (int i = 0; i < results.length(); i++) {
                        Log.i("DATA", results.getJSONObject(i).getString("question"));
                        JSONObject questionObj = results.getJSONObject(i);
                        // make sure to decode the html string
                        quizQuestions.add(new QuizQuestion(Html.fromHtml(questionObj.getString("question")).toString(), questionObj.getBoolean("correct_answer")));
                    }

                    mCardStackView = activity.findViewById(R.id.myCardStackView);
                    mCardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                    mCardStackView.setAdapter(new CardStackAdapter(mContext, quizQuestions)); // set the adapter
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", error.getMessage());
                Toast.makeText(mContext, "Unsuccessful Call", Toast.LENGTH_SHORT).show();
            }
        });

        mRequestQueue.add(filmsJsonObjectRequest);

    }


}
