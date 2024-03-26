package frog.social.moviereviewapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import frog.social.moviereviewapp.data.local.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    suspend fun getUserByEmailAndPassword(email: String, password: String): User?
}