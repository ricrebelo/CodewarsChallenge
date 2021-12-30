package com.codewars.challenge.database.dao

import androidx.room.*
import com.codewars.challenge.database.entity.Challenges
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface ChallengesDao {
    @Query("SELECT * FROM challenges")
    fun getAll(): Flow<List<Challenges>>

    @Query("SELECT * FROM challenges WHERE username = :userName")
    fun getChallengesByUserName(userName: String): List<Challenges>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: Challenges)

    @Delete
    fun delete(user: Challenges)
}