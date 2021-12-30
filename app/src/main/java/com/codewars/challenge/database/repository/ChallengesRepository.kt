package com.codewars.challenge.database.repository

import com.codewars.challenge.database.dao.ChallengesDao
import com.codewars.challenge.database.entity.Challenges
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChallengesRepository @Inject constructor(
    private val challengesDao: ChallengesDao
){
    fun insert(challenges: Challenges) = challengesDao.insert(challenges)
    fun delete(challenges: Challenges) = challengesDao.delete(challenges)
    fun getAll() = challengesDao.getAll()
    fun getChallengesByUserName(userName: String) = challengesDao.getChallengesByUserName(userName)
}