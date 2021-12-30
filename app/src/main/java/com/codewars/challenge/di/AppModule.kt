package com.codewars.challenge.di

import android.content.Context
import androidx.room.Room
import com.codewars.challenge.database.dao.UserDao
import com.codewars.challenge.database.database.AppDatabase
import com.codewars.challenge.web.Endpoints
import com.codewars.challenge.web.ApiManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database"
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) : UserDao = db.userDao()

    @Singleton
    @Provides
    fun providesEndpoints(networkManager: ApiManager) : Endpoints = networkManager.build()
}