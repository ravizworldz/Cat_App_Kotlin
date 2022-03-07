package com.test.synchronyapp

import android.app.Application
import com.test.synchronyapp.di.AppModule
import com.test.synchronyapp.di.DaggerIAppComponent
import com.test.synchronyapp.di.IAppComponent

class SynchronyApp: Application() {

    private lateinit var appComponent: IAppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerIAppComponent.builder()
            .appModule(AppModule(this@SynchronyApp))
            .build()
    }

    /**
     * Return DI component
     */
    fun getAppComponent(): IAppComponent {
        return appComponent
    }
}