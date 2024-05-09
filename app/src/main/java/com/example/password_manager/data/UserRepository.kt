package com.example.password_manager.data

import kotlinx.coroutines.coroutineScope

class UserRepository(
    private val userDao: UserDao
) {

    val readAllData = userDao.readAllData()

    suspend fun addUser(user:User)
    {
        coroutineScope {
            userDao.addUser(user)
        }
    }

    suspend fun  removeUser(user:User)
    {
        coroutineScope {
            userDao.removeUser(user)
        }
    }
}