package frog.social.moviereviewapp.ui.activity.movieslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import frog.social.moviereviewapp.data.repository.MovieRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {

    fun getMovies(){
        viewModelScope.launch {
            val response = repository.getMovies("love")

            Log.d("RESPONSE", response.toString())
        }
    }
}