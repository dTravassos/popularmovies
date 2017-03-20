package com.udacity.movies.exam.diogo.popularmovies.model;

public class Movie {

    private String thumbnailUrl;

    public Movie(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
