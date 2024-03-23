package frog.social.moviereviewapp.ui.activity.signup

import android.util.Log
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

    fun insertUser(user: User){
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    fun getUsers(){
        viewModelScope.launch {
            val users = repository.getAllUsers()

            Log.d("USER", "==========${users.size} ==========")
        }
    }
}