package com.ishak.movie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.androidannotations.annotations.Background
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

class MainActivity : AppCompatActivity() {
    internal val TOKEN_KEY : String = "2355b1b47f82aa9755293fd5df901f19"
    internal val LANGUAGE: String = "fr"
    internal val BASE_URL: String = "https://api.themoviedb.org/3/search/"

    internal lateinit var edtText: EditText
    internal lateinit var api: Iserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fabric.with(this, Crashlytics())

        setContentView(R.layout.activity_main)

        edtText = findViewById(R.id.edtText)

        initApi()
    }

    @Background
    fun searchMovie(view: View) {
        var movies: List<Movie>? = ArrayList<Movie>()
        var text: String = edtText.text.toString()
        if(text.isEmpty()) {
            Toast.makeText(this, "Saissir un text à chercher.", Toast.LENGTH_LONG).show()
            return
        }

        var exec = api.searchMovie(TOKEN_KEY, LANGUAGE, text).enqueue(object : Callback<ServerResponse>{
            override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                if (response.isSuccessful){
                    movies = response.body()?.movies

                    Toast.makeText(this@MainActivity, movies.toString(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    fun forceCrash(view: View) {
        throw RuntimeException("This is a crash")
    }

    fun initApi(){
        var gson = GsonBuilder()
            .setLenient()
            .create()

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        api = retrofit.create(Iserver::class.java)
    }


}
