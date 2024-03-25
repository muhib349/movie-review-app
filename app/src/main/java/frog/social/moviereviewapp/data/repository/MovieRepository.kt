package frog.social.moviereviewapp.data.repository

import frog.social.moviereviewapp.data.model.MovieSearchResponse
import frog.social.moviereviewapp.data.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovies(title: String) : Response<MovieSearchResponse> {
        return apiService.getMovies(title)
    }
}