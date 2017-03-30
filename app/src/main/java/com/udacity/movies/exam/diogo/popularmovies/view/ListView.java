package com.udacity.movies.exam.diogo.popularmovies.view;

import com.udacity.movies.exam.diogo.popularmovies.model.Movie;

import java.util.List;

public interface ListView {

    void loadImageAdapter(List<Movie> items);

    void showInternetLostInfo();

    void showReconnectButton();

    void hideReconnectButton();

    void alertGenericError();
}
