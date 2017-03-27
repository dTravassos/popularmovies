package com.udacity.movies.exam.diogo.popularmovies.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.udacity.movies.exam.diogo.popularmovies.fragment.MovieDetailFragment;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buildActionBar();

        if (savedInstanceState == null) {
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();
            getFragmentManager().executePendingTransactions();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        this.finish();
    }

    private void buildActionBar() {
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
