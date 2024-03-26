package frog.social.moviereviewapp.ui.activity.login

import android.util.Log
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
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user
    fun login(email: String, password: String){
        viewModelScope.launch {
            _user.value = repository.getUserByEmailAndPassword(email, password)
        }
    }
}