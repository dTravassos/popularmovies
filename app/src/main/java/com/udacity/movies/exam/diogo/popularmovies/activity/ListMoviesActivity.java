package com.udacity.movies.exam.diogo.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.presenter.ListMoviesPresenterImpl;
import com.udacity.movies.exam.diogo.popularmovies.view.ListMoviesView;

public class ListMoviesActivity extends AppCompatActivity implements ListMoviesView {

    private static String TAG = ListMoviesActivity.class.getSimpleName();

    ListMoviesPresenterImpl presenter = new ListMoviesPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);

        Log.d(TAG, "Initializing");

        presenter.onCreate();
    }

}
