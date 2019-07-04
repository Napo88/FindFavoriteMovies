package com.ishak.movie

import com.google.gson.annotations.SerializedName

class Movie {
    var id: Int

    var title: String

    @SerializedName("vote_average")
    var vote: String

    var overview: String

    @SerializedName("release_date")
    var releaseDate: String

    constructor(id: Int, title: String, vote: String, overview: String, releaseDate: String) {
        this.id = id
        this.title = title
        this.vote = vote
        this.overview = overview
        this.releaseDate = releaseDate
    }

    override fun toString(): String {
        return "Movie(id=$id, title='$title', vote='$vote', overview='$overview', releaseDate='$releaseDate')"
    }


}