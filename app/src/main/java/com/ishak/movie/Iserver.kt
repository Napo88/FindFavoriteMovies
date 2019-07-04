package com.ishak.movie

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Iserver {


    @POST("movie")
    fun searchMovie(
        @Query("api_key") apiKey : String,
        @Query("language") lang: String,
        @Query("query") text: String
    ): Call<ServerResponse>
}