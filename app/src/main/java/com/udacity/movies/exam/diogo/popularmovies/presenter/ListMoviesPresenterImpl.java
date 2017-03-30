package com.udacity.movies.exam.diogo.popularmovies.presenter;

import android.content.Context;
import android.util.Log;

import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.helpers.PermissionsHelper;
import com.udacity.movies.exam.diogo.popularmovies.helpers.PreferenceHelper;
import com.udacity.movies.exam.diogo.popularmovies.model.ResponseMovies;
import com.udacity.movies.exam.diogo.popularmovies.repository.RemoteMoviesRepository;
import com.udacity.movies.exam.diogo.popularmovies.view.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMoviesPresenterImpl implements BasePresenter, Callback<ResponseMovies> {

    private static String TAG = ListMoviesPresenterImpl.class.getSimpleName();

    private RemoteMoviesRepository repository = new RemoteMoviesRepository();

    private ListView view;

    public ListMoviesPresenterImpl(ListView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
       loadView();
    }

    public void loadView() {
        String sortBy = PreferenceHelper.getOrganizeMovieListType(getContext());

        loadView(sortBy);
    }

    private void loadView(String searchParam) {
        if (PermissionsHelper.isOnline((Context) view)) {
            fetchData(searchParam);
        } else {
            view.showInternetLostInfo();
            view.showReconnectButton();
        }
    }

    public void loadViewTopRatedMovies() {
        fetchData(getContext().getResources().getString(R.string.pref_search_top_value));
    }

    public void loadViewMostPopularMovies() {
        fetchData(getContext().getResources().getString(R.string.pref_search_popular_value));
    }

    private void fetchData(String sortBy) {
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
