package com.test.synchronyapp.di

import com.test.synchronyapp.ui.fragment.CatBreedsListFragment
import com.test.synchronyapp.ui.fragment.HomeActivityViewModel
import com.test.synchronyapp.viewmodel.CatBreedsListViewModel
import com.test.synchronyapp.viewmodel.CreateProfileViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface IAppComponent {
    fun inject(catBreedsListViewModel: CatBreedsListViewModel)
    fun inject(createProfileViewModel: CreateProfileViewModel)
    fun inject(homeActivityViewModel: HomeActivityViewModel)
}