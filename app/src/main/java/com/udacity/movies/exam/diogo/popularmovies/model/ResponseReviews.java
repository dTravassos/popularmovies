package com.udacity.movies.exam.diogo.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseReviews {

    @SerializedName("id")
    private Integer id;

    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<Review> results = new ArrayList<Review>();

    @SerializedName("total_results")
    private String totalResults;

    @SerializedName("total_pages")
    private String totalPages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Review> getResults() {
        return results;
    }

    public void setResults(List<Review> results) {
        this.results = results;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }
}
