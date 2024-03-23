package frog.social.moviereviewapp.data.local.repository

import frog.social.moviereviewapp.data.local.dao.UserDao
import frog.social.moviereviewapp.data.local.entity.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}