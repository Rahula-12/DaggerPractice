package com.example.android.hilt.di

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.example.android.hilt.ui.ButtonsFragment
import com.example.android.hilt.ui.LogsFragment
import com.example.android.hilt.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LogDatabaseModule::class])
interface ActivityComponent{

    fun inject(mainActivity: MainActivity)

    fun inject(buttonsFragment: ButtonsFragment)

    fun inject(logsFragment: LogsFragment)
    @Component.Builder
    interface Builder{

        fun build():ActivityComponent

        fun provideApplicationContext(@BindsInstance appContext:Application):Builder

        fun provideActivityContext(@BindsInstance activityContext: FragmentActivity):Builder

    }

}