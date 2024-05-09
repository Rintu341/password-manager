package com.example.password_manager.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

//    val readAllData:Flow<List<User>> = userDao.readAllData().flowOn(Dispatchers.IO).conflate()

    fun readAllData():Flow<List<User>> = userDao.readAllData().flowOn(Dispatchers.IO).conflate()

    suspend fun addUser(user:User)
    {
            userDao.addUser(user)
    }

    suspend fun  removeUser(user:User)
    {
            userDao.removeUser(user)
    }
}