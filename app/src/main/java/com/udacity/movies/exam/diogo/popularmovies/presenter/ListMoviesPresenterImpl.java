package com.udacity.movies.exam.diogo.popularmovies.presenter;

import android.util.Log;

import com.udacity.movies.exam.diogo.popularmovies.model.ResponseMovies;
import com.udacity.movies.exam.diogo.popularmovies.network.MovieDbConnector;
import com.udacity.movies.exam.diogo.popularmovies.view.ListMoviesView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListMoviesPresenterImpl implements BasePresenter, Callback<ResponseMovies> {

    private static String TAG = ListMoviesPresenterImpl.class.getSimpleName();

    ListMoviesView view;

    public ListMoviesPresenterImpl(ListMoviesView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        fetchData();
    }

    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieDbConnector.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieDbConnector service = retrofit.create(MovieDbConnector.class);

        final Call<ResponseMovies> movies = service.listMovies("popular", "");

        movies.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
        if(response.isSuccessful()) {
            ResponseMovies movies = response.body();
            view.loadImageAdapter(movies.getResults());
        } else {
            Log.e(TAG, response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<ResponseMovies> call, Throwable t) {
        Log.e(TAG, t.getMessage());
    }
}
