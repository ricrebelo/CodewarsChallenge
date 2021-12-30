package com.codewars.challenge.database.repository

import com.codewars.challenge.database.dao.UserDao
import com.codewars.challenge.database.entity.User
import javax.inject.Inject

class UserRepository @Inject  constructor(
    private val userDao: UserDao
){
    suspend fun insert(user: User) = userDao.insert(user)
    suspend fun delete(user: User) = userDao.delete(user)
    suspend fun getAll() = userDao.getAll()
}