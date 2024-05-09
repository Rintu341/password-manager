package com.example.password_manager.data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    abstract  fun userDao():UserDao

}