package com.example.quiz_t_f_app.view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_t_f_app.R;

public class FilmViewHolder extends RecyclerView.ViewHolder {

    private TextView txtFilmQuestion;
    private ImageButton imgButtonTrue;
    private ImageButton imgButtonFalse;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);

        txtFilmQuestion = itemView.findViewById(R.id.film_question_text); // retrieves the film question text element
        imgButtonTrue = itemView.findViewById(R.id.trueButton); // retrieves true btn element
        imgButtonFalse = itemView.findViewById(R.id.falseButton); // retrieves false btn element

    }

    public TextView getTxtFilmQuestion() {
        return txtFilmQuestion;
    }

    public void setTxtFilmQuestion(TextView txtFilmQuestion) {
        this.txtFilmQuestion = txtFilmQuestion;
    }

    public ImageButton getImgButtonTrue() {
        return imgButtonTrue;
    }

    public void setImgButtonTrue(ImageButton imgButtonTrue) {
        this.imgButtonTrue = imgButtonTrue;
    }

    public ImageButton getImgButtonFalse() {
        return imgButtonFalse;
    }

    public void setImgButtonFalse(ImageButton imgButtonFalse) {
        this.imgButtonFalse = imgButtonFalse;
    }
}
