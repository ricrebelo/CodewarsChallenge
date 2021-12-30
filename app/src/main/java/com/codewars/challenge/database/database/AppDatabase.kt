package com.codewars.challenge.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.codewars.challenge.database.dao.ChallengesDao
import com.codewars.challenge.database.entity.Challenges
import com.codewars.challenge.database.utils.Converters

@Database(
    entities = [Challenges::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun challengesDao(): ChallengesDao
}