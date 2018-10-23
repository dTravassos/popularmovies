package com.udacity.movies.exam.diogo.popularmovies.network;

import com.udacity.movies.exam.diogo.popularmovies.model.ResponseMovies;
import com.udacity.movies.exam.diogo.popularmovies.model.ResponseReviews;
import com.udacity.movies.exam.diogo.popularmovies.model.ResponseVideos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDbConnector {

    String BASE_URL ="https://api.themoviedb.org/3/";

    @GET("movie/{sort_order}")
    Call<ResponseMovies> listMovies(@Path("sort_order") String sortOrder, @Query("api_key") String MyApiKey);

    @GET("movie/{movie_id}/reviews")
    Call<ResponseReviews> listMovieReviews(@Path("movie_id") String movie_id, @Query("api_key") String MyApiKey);

    @GET("movie/{movie_id}/videos")
    Call<ResponseVideos> listMovieVideos(@Path("movie_id") String movie_id, @Query("api_key") String MyApiKey);
}
