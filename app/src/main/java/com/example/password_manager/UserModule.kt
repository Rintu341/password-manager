package com.example.password_manager

import android.content.Context
import androidx.room.Room
import com.example.password_manager.data.UserDao
import com.example.password_manager.data.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
object UserModule {


    @Singleton
    @Provides
    fun provideUsersDao(userDatabase: UserDatabase):UserDao
            = userDatabase.userDao()

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context):UserDatabase
            = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        "user_db"
    ).fallbackToDestructiveMigration()
        .build()
}