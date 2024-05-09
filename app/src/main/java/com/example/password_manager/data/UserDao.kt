package com.example.password_manager.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:User)

    @Delete
    suspend fun removeUser(user:User)

    @Query("SELECT * FROM USER_TABLE ORDER BY ID ASC")
    fun readAllData():Flow<List<User>>

}