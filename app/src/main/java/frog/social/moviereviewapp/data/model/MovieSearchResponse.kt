package frog.social.moviereviewapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieSearchResponse (
    @SerializedName("Search")
    val search: List<MovieSearchItem>,
    val totalResults: String,
    @SerializedName("Response")
    val response: String,
)