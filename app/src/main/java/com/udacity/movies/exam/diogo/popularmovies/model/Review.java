package com.udacity.movies.exam.diogo.popularmovies.model;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("id")
    private String id;

    @SerializedName("author")
    private Integer author;

    @SerializedName("content")
    private Integer content;

    @SerializedName("url")
    private Integer url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }
}
