package com.test.synchronyapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.synchronyapp.R
import com.test.synchronyapp.SynchronyApp
import com.test.synchronyapp.models.entity.UserProfileEntity
import com.test.synchronyapp.ui.fragment.HomeActivityViewModel
import com.test.synchronyapp.viewmodel.repository.SplashViewModel

class SplashActivity : BaseActivity() {
    private lateinit var viewModel: SplashViewModel
    private lateinit var  homeActivityViewModel: HomeActivityViewModel
    override fun getLayoutResourceId(): Int {
        return R.layout.activity_splash
    }

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
        initObservers()
    }

    /**
     * Initialize view model
     */
    override fun onViewModelInit() {
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        homeActivityViewModel = ViewModelProvider(this, object: ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeActivityViewModel(applicationContext as SynchronyApp) as T
            }
        }).get(HomeActivityViewModel::class.java)
    }

    /**
     * Register the observer to observe results from viewmodel
     */
    private fun initObservers() {
        viewModel.getSplashObserver().observe(this, Observer <Boolean>{
            homeActivityViewModel.getProfile()
        })
        homeActivityViewModel.getProfileObserver().observe(this, Observer <List<UserProfileEntity>>{
            if(it != null && it.size > 0)
                launchHome()
            else
                launchCreateProfile()
        })
        viewModel.startSplashDelay()
    }

    /**
     * Launch the school list activity and close itself
     */
    private fun launchCreateProfile() {
        val i = Intent(this@SplashActivity, CreateProfileActivity::class.java)
        startActivity(i)
        finish()
    }

    /**
     * Launch HOme activity.
     */
    private fun launchHome() {
        val i = Intent(this@SplashActivity, HomeActivity::class.java)
        startActivity(i)
        finish()
    }
}