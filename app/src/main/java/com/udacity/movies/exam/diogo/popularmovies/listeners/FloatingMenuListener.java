package com.udacity.movies.exam.diogo.popularmovies.listeners;

import android.view.View;

import com.github.clans.fab.FloatingActionMenu;
import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.presenter.ListMoviesPresenterImpl;

public class FloatingMenuListener implements View.OnClickListener {

    private FloatingActionMenu menu;

    private ListMoviesPresenterImpl presenter;

    public FloatingMenuListener(FloatingActionMenu menu,  ListMoviesPresenterImpl presenter) {
        this.menu = menu;
        this.presenter = presenter;
    }

    public void onClick(View v) {
        menu.close(true);

        if (R.id.menu_item_top_rated == v.getId()) {
            presenter.loadViewTopRatedMovies();
        } else  if (R.id.menu_item_most_popular == v.getId()) {
            presenter.loadViewMostPopularMovies();
        }


    }
}