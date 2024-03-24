package frog.social.moviereviewapp.data.repository

import android.util.Log
import frog.social.moviereviewapp.data.remote.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovies(title: String){
        val response = apiService.getMovies(title)

        Log.d("RESPONSE", "${response.code()}")
    }
}