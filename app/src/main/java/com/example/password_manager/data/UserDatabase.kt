package com.example.password_manager.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    abstract  fun userDao():UserDao

    /*
    companion object{
        //The @Volatile annotation ensures that changes made to INSTANCE are immediately visible to all threads.
        @Volatile
        private var INSTANCE:UserDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context):UserDatabase
        {
            val tempInstance = INSTANCE
            if(tempInstance != null) // If Instance is already exist
            {
                return tempInstance
            }
//            The synchronized block is used to prevent multiple threads from creating multiple instances of the database.
            kotlinx.coroutines.internal.synchronized(this)
            {
                val instance = Room.databaseBuilder( //create new instance if not exist
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
     */

}