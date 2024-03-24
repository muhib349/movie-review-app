package frog.social.moviereviewapp.ui.activity.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import frog.social.moviereviewapp.data.local.entity.User
import frog.social.moviereviewapp.data.local.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel(){
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users


    fun getUsers(){
        viewModelScope.launch {
            _users.value = repository.getAllUsers()
        }
    }
}