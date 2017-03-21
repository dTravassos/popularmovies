package com.udacity.movies.exam.diogo.popularmovies.network;

import com.udacity.movies.exam.diogo.popularmovies.model.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDbConnector {

    String BASE_URL ="https://api.themoviedb.org/3/";

    @GET("movie/{sort_order}")
    Call<ResponseMovies> listMovies(@Path("sort_order") String sortOrder, @Query("api_key") String MyApiKey);

}
