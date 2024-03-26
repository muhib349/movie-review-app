package frog.social.moviereviewapp.ui.activity.movieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import frog.social.moviereviewapp.data.model.MovieSearchResponse
import frog.social.moviereviewapp.data.remote.ErrorResponse
import frog.social.moviereviewapp.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {

    private val _moviesData = MutableLiveData<MovieSearchResponse>()
    val moviesData: LiveData<MovieSearchResponse> = _moviesData

    private val _errorResponse = MutableLiveData<ErrorResponse>()
    val errorResponse: LiveData<ErrorResponse> = _errorResponse

    fun getMovies(pageNumber: Int){
        viewModelScope.launch {
            val response = repository.getMovies(pageNumber)

            if (response.isSuccessful){
                _moviesData.value = response.body()
            }else{
                _errorResponse.value = ErrorResponse(response.code(), response.message())
            }
        }
    }
}