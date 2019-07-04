package com.ishak.movie

import com.google.gson.annotations.SerializedName

class ServerResponse {
    var page: Int

    @SerializedName("total_results")
    var totalResults: Int

    @SerializedName("total_pages")
    var totalPages: Int

    @SerializedName("results")
    var movies: List<Movie>

    constructor(page: Int, totalResults: Int, totalPages: Int, movies: List<Movie>) {
        this.page = page
        this.totalResults = totalResults
        this.totalPages = totalPages
        this.movies = movies
    }
}