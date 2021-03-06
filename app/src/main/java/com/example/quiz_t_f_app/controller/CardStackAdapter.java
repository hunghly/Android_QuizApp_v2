package com.example.quiz_t_f_app.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_t_f_app.R;
import com.example.quiz_t_f_app.model.QuizQuestion;
import com.example.quiz_t_f_app.view.FilmViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private Context mContext;
    private List<QuizQuestion> mFilmQuestions;
    private LayoutInflater mLayoutInflater;

    public CardStackAdapter(Context context, List<QuizQuestion> filmQuestions) {
        mContext = context;
        mFilmQuestions = filmQuestions;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.film_view, parent, false);
        return new FilmViewHolder(view);
    }

    // the main function called for each item in the list
    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, final int position) {
        holder.getTxtFilmQuestion().setText(mFilmQuestions.get(position).getQuestionText()); // sets the text for the txtFilm element
        // adds event listeners for each button
        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFilmQuestions.get(position).isTrueAnswer()) {
                    Toast.makeText(mContext, "You are correct, congrats!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "You are wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mFilmQuestions.get(position).isTrueAnswer()) {
                    Toast.makeText(mContext, "You are correct, congrats!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "You are wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilmQuestions.size(); // the number of items we want to show in our card view
    }
}
