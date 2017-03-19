package com.udacity.movies.exam.diogo.popularmovies.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callListMoviesActivity(this);
    }

    private void callListMoviesActivity(Context context) {
        Intent intent = new Intent(context, ListMoviesActivity.class);
        startActivity(intent);
        finish();
    }
}
