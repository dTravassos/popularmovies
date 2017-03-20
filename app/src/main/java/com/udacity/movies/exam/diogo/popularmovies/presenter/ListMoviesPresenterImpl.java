package com.udacity.movies.exam.diogo.popularmovies.presenter;

import com.udacity.movies.exam.diogo.popularmovies.model.Movie;
import com.udacity.movies.exam.diogo.popularmovies.view.ListMoviesView;

import java.util.ArrayList;
import java.util.List;

public class ListMoviesPresenterImpl implements BasePresenter {

    ListMoviesView view;

    public ListMoviesPresenterImpl(ListMoviesView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.loadImageAdapter(fetchData());
    }

    private List<Movie> fetchData() {
        List<Movie> data = new ArrayList<Movie>();
        data.add(new Movie("http://goo.gl/gEgYUd"));
        data.add(new Movie("http://i.imgur.com/DvpvklR.png"));
        data.add(new Movie("http://goo.gl/gEgYUd"));
        data.add(new Movie("http://i.imgur.com/DvpvklR.png"));
        data.add(new Movie("http://goo.gl/gEgYUd"));
        data.add(new Movie("http://i.imgur.com/DvpvklR.png"));
        data.add(new Movie("http://goo.gl/gEgYUd"));
        data.add(new Movie("http://i.imgur.com/DvpvklR.png"));
        data.add(new Movie("http://goo.gl/gEgYUd"));
        data.add(new Movie("http://i.imgur.com/DvpvklR.png"));

        return data;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
