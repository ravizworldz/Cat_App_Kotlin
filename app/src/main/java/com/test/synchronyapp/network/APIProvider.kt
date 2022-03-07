package com.test.synchronyapp.network

import com.test.synchronyapp.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIProvider{

    fun getRetroInstance(): Retrofit {

        /**
         * Enable Retrofit logging.
         */
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)

        /**
         * Return retrofit instance.
         */
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}