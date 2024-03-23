package frog.social.moviereviewapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import frog.social.moviereviewapp.data.local.dao.UserDao
import frog.social.moviereviewapp.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}