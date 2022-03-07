package com.test.synchronyapp.di

import com.test.synchronyapp.viewmodel.CatBreedListViewModelTest
import com.test.synchronyapp.viewmodel.CatProfileListViewModelTest
import com.test.synchronyapp.viewmodel.DaoTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface TestAppComponent: IAppComponent {
    fun inject(catBreedListViewModelTest: CatBreedListViewModelTest)
    fun inject(catProfileListViewModelTest: CatProfileListViewModelTest)
    fun inject(daoTest: DaoTest)
}