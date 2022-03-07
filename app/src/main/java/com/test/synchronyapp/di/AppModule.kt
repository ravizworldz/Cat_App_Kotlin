package com.test.synchronyapp.di

import android.content.Context
import com.test.synchronyapp.SynchronyApp
import com.test.synchronyapp.db.AppDatabase
import com.test.synchronyapp.db.UserProfileDao
import com.test.synchronyapp.network.APIProvider
import com.test.synchronyapp.network.IAPIService
import com.test.synchronyapp.utils.AppConnectivityManager
import com.test.synchronyapp.utils.AppConstants
import com.test.synchronyapp.viewmodel.repository.CatBreedsListRepository
import com.test.synchronyapp.viewmodel.repository.CreateProfileRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class AppModule(private val application: SynchronyApp) {
    @Singleton
    @Provides
    fun getApiServiceInstance(retrofit: Retrofit): IAPIService {
        return retrofit.create(IAPIService::class.java)
    }

    @Provides
    @Singleton
    open fun getApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    open fun getConnectivityManager(): AppConnectivityManager {
        return AppConnectivityManager(getApplicationContext())
    }

    @Singleton
    @Provides
    open fun getUserProfileDao(appDatabase: AppDatabase): UserProfileDao {
        return appDatabase.getUserProfileDao()
    }

    @Singleton
    @Provides
    open fun getRoomDbInstance(context: Context): AppDatabase {
        return AppDatabase.getAppDBInstance(context)
    }

    @Singleton
    @Provides
    open fun getAPIProviderInstance(): Retrofit {
        return APIProvider.getRetroInstance()
    }

    @Singleton
    @Provides
    fun getCatBreedsListRepository(apiService: IAPIService): CatBreedsListRepository {
        return CatBreedsListRepository(apiService)
    }

    @Singleton
    @Provides
    fun getCreateProfileRepository(userProfileDao: UserProfileDao): CreateProfileRepository {
        return CreateProfileRepository(userProfileDao)
    }
}