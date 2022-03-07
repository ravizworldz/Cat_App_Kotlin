package com.test.synchronyapp.di

import android.app.Application
import com.test.synchronyapp.SynchronyApp
import com.test.synchronyapp.utils.AppConnectivityManager
import android.content.Context
import com.test.synchronyapp.db.AppDatabase
import com.test.synchronyapp.db.UserProfileDao
import io.mockk.mockk

class TestAppModule(private val application: Application): AppModule(application as SynchronyApp) {
    override fun getApplicationContext(): Context {
        return application
    }

    override fun getConnectivityManager(): AppConnectivityManager {
        return  mockk()
    }

    override fun getRoomDbInstance(context: Context): AppDatabase {
        return mockk()
    }

    override fun getUserProfileDao(appDatabase: AppDatabase): UserProfileDao {
        return mockk()
    }
}