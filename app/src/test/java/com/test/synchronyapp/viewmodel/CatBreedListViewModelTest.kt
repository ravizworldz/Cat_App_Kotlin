package com.test.synchronyapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.synchronyapp.SynchronyApp
import com.test.synchronyapp.di.DaggerIAppComponent
import com.test.synchronyapp.di.DaggerTestAppComponent
import com.test.synchronyapp.di.TestAppModule
import com.test.synchronyapp.utils.DataCallback
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Test

class CatBreedListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    val context: SynchronyApp = mockk()

    lateinit var viewModel: CatBreedsListViewModel

    val catBreedsListViewModelMocked: CatBreedsListViewModel = mockk()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val component = DaggerTestAppComponent.builder()
            .appModule(TestAppModule(application = context)).build()

        component.inject(this)
        every { context.getAppComponent() } returns component
        viewModel = CatBreedsListViewModel(context)
    }
    @Test
    fun test_get_cats_list_loading() {
        every { catBreedsListViewModelMocked.getCatBreedsList() }answers {
            viewModel.getCatBreedsListObserver().value = DataCallback.loading( null )
        }
        catBreedsListViewModelMocked.getCatBreedsList()
        TestCase.assertEquals(DataCallback.Status.LOADING, viewModel.getCatBreedsListObserver().value?.status)
    }

    @Test
    fun test_get_cats_list_success() {
        every { catBreedsListViewModelMocked.getCatBreedsList() }answers {
            viewModel.getCatBreedsListObserver().value = DataCallback.success(null, null)
        }
        catBreedsListViewModelMocked.getCatBreedsList()
        TestCase.assertEquals(DataCallback.Status.SUCCESS, viewModel.getCatBreedsListObserver().value?.status)
    }

    @Test
    fun test_get_cats_list_error() {
        every { catBreedsListViewModelMocked.getCatBreedsList() }answers {
            viewModel.getCatBreedsListObserver().value = DataCallback.error(null, null)
        }
        catBreedsListViewModelMocked.getCatBreedsList()
        TestCase.assertEquals(DataCallback.Status.ERROR, viewModel.getCatBreedsListObserver().value?.status)
    }
}