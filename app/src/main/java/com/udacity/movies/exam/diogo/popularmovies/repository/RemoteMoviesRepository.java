package com.udacity.movies.exam.diogo.popularmovies.repository;

import com.udacity.movies.exam.diogo.popularmovies.BuildConfig;
import com.udacity.movies.exam.diogo.popularmovies.model.ResponseMovies;
import com.udacity.movies.exam.diogo.popularmovies.network.MovieDbConnector;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteMoviesRepository {

    private Retrofit build() {
       return new Retrofit.Builder()
                .baseUrl(MovieDbConnector.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<ResponseMovies> list() {
        return listBy("popular");
    }

    public Call<ResponseMovies> listBy(String listType) {
        Retrofit retrofit = this.build();
        MovieDbConnector connector = retrofit.create(MovieDbConnector.class);

        return connector.listMovies(listType, BuildConfig.MDB_KEY);
    }
}
