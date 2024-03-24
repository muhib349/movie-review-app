package frog.social.moviereviewapp.data.remote

import frog.social.moviereviewapp.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getMovies(@Query("t") t: String): Response<Movie>
}