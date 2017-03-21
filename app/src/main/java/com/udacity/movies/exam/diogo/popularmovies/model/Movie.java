package com.udacity.movies.exam.diogo.popularmovies.model;

public class Movie {

    private String id;

    private String poster_path;

    private boolean adult = false;

    private String overview;

    private String release_date;

    private String original_title;

    private String original_language;

    private String title;

    private String backdrop_path;

    private String popularity;

    private String vote_count;

    private boolean video = false;

    private String vote_average;

    public Movie(String posterPath) {
        this.poster_path = posterPath;
    }

    public Movie(String id, String posterPath, boolean adult, String overview, String releaseDate, String original_title,
                 String original_language, String title, String backdrop_path, String popularity, String vote_count,
                 boolean video, String vote_average) {
        this.id = id;
        this.poster_path = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.release_date = releaseDate;
        this.original_title = original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbUrl() {
        return "http://image.tmdb.org/t/p/w185" + this.poster_path;
    }
}
