package frog.social.moviereviewapp.data.remote

import frog.social.moviereviewapp.data.model.MovieSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getMovies(@Query("s") t: String): Response<MovieSearchResponse>
}