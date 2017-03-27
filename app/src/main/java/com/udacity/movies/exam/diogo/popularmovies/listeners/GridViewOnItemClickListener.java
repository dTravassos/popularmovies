package com.udacity.movies.exam.diogo.popularmovies.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.udacity.movies.exam.diogo.popularmovies.activity.ListMoviesActivity;
import com.udacity.movies.exam.diogo.popularmovies.model.Movie;

public class GridViewOnItemClickListener implements AdapterView.OnItemClickListener {

    ListMoviesActivity activity;

    public GridViewOnItemClickListener(ListMoviesActivity activity) {
        this.activity = activity;

    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        ListAdapter adapter = ((GridView) parent).getAdapter();
        Movie movie = (Movie) adapter.getItem(position);

        activity.callMovieDetailActivity(movie);
    }
}
