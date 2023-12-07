package com.example.android.hilt.di

import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.AppNavigatorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LogDatabaseModule {

    @Singleton
    @Provides
    fun providesLogDatabase(appContext:Application):AppDatabase= Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "logging.db"
    ).build()

    @Singleton
    @Provides
    fun providesDao(appDatabase: AppDatabase)= appDatabase.logDao()

    @Provides
    fun provideNavigator(activityContext: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activityContext as FragmentActivity)
    }

}