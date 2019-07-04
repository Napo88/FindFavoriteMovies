package com.ishak.movie

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MovieAdapter(_context: Context, _movies: List<Movie>): BaseAdapter() {
    var movies: List<Movie> = _movies
    var context: Context = _context


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
        return movies[position]
    }

    override fun getItemId(position: Int): Long {
        return movies[position].id as Long
    }

    override fun getCount(): Int {
        return movies.size
    }
}