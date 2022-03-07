package com.test.synchronyapp.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.synchronyapp.SynchronyApp
import com.test.synchronyapp.models.entity.UserProfileEntity
import com.test.synchronyapp.viewmodel.repository.CreateProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeActivityViewModel (appContext: SynchronyApp): ViewModel() {

    private var profileObserver: MutableLiveData<List<UserProfileEntity>>

    @Inject
    lateinit var createProfileRepository: CreateProfileRepository

    init {
        appContext.getAppComponent().inject(this)
        profileObserver = MutableLiveData()
    }

    /**
     * return observer to called when delay is completed.
     * need to be observed on activity
     */
    fun getProfileObserver(): MutableLiveData<List<UserProfileEntity>> {
        return profileObserver
    }

    /**
     * Called to save data in db
     */
    fun getProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            createProfileRepository.getAllRecords( profileObserver)
        }
    }
}