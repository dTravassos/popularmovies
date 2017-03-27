package com.udacity.movies.exam.diogo.popularmovies.model;

import java.io.Serializable;

public class Movie implements Serializable {

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
        return "http://image.tmdb.org/t/p/w185" + this.backdrop_path;
    }

    public String getPosterUrl() {
        return "http://image.tmdb.org/t/p/w185" + this.poster_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
