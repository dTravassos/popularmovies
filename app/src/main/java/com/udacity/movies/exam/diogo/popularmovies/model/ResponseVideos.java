package com.udacity.movies.exam.diogo.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseVideos {

    @SerializedName("id")
    private Integer id;

    @SerializedName("results")
    private List<Video> results = new ArrayList<Video>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
    }
}
