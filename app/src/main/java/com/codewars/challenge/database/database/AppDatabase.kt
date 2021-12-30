package com.codewars.challenge.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codewars.challenge.database.dao.UserDao
import com.codewars.challenge.database.entity.User

@Database(
    entities = arrayOf(User::class),
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}