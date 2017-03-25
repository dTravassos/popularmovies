package com.udacity.movies.exam.diogo.popularmovies.presenter;

import android.content.Context;
import android.util.Log;

import com.udacity.movies.exam.diogo.popularmovies.helpers.PermissionsHelper;
import com.udacity.movies.exam.diogo.popularmovies.helpers.PreferenceHelper;
import com.udacity.movies.exam.diogo.popularmovies.model.ResponseMovies;
import com.udacity.movies.exam.diogo.popularmovies.repository.RemoteMoviesRepository;
import com.udacity.movies.exam.diogo.popularmovies.view.ListMoviesView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMoviesPresenterImpl implements BasePresenter, Callback<ResponseMovies> {

    private static String TAG = ListMoviesPresenterImpl.class.getSimpleName();

    private RemoteMoviesRepository repository = new RemoteMoviesRepository();

    private ListMoviesView view;

    public ListMoviesPresenterImpl(ListMoviesView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
       loadView();
    }

    public void loadView() {
        if (PermissionsHelper.isOnline((Context) view)) {
            fetchData();
        } else {
            view.internetLostDialog();
        }
    }

    private void fetchData() {
        String sortBy = PreferenceHelper.getOrganizeMovieListType(getContext());

        final Call<ResponseMovies> movies = repository.listBy(sortBy);

        movies.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
        if(response.isSuccessful()) {
            ResponseMovies movies = response.body();
            view.loadImageAdapter(movies.getResults());
        } else {
            Log.e(TAG, response.errorBody().toString());
            view.alertGenericError();
        }
    }

    private Context getContext() {
        return (Context) view;
    }

    @Override
    public void onFailure(Call<ResponseMovies> call, Throwable t) {
        Log.e(TAG, t.getMessage());
    }
}
