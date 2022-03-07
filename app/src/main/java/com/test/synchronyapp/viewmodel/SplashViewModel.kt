package com.test.synchronyapp.viewmodel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private var splashObserver: MutableLiveData<Boolean>
    private var job: Job? = null
    init {
        splashObserver = MutableLiveData()
    }

    /**
     * return observer to called when delay is completed.
     * need to be observed on activity
     */
    fun getSplashObserver(): LiveData<Boolean> {
        return splashObserver
    }

    /**
     * Called to generate 4 sec of delay to complete the animation on splash
     */
    fun startSplashDelay() {
        job = viewModelScope.launch(Dispatchers.IO) {
            Thread.sleep(6000)
            splashObserver.postValue(true)
        }
    }

    /**
     * Called when view model destroyed.
     */
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}