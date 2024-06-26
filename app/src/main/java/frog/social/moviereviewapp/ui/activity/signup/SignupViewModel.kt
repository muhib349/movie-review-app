package frog.social.moviereviewapp.ui.activity.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import frog.social.moviereviewapp.data.local.dao.UserDao
import frog.social.moviereviewapp.data.local.entity.User
import frog.social.moviereviewapp.data.local.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _isUserAdded = MutableLiveData<Boolean>()
    val isUserAdded: LiveData<Boolean> = _isUserAdded

    init {
        _isUserAdded.value = false
    }
    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
            _isUserAdded.value = true
        }
    }
}