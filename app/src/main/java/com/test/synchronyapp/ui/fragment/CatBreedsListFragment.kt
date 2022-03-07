package com.test.synchronyapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.synchronyapp.R
import com.test.synchronyapp.SynchronyApp
import com.test.synchronyapp.models.CatBreedList
import com.test.synchronyapp.models.CatBreedListItem
import com.test.synchronyapp.ui.adapter.CatBreedListAdapter
import com.test.synchronyapp.ui.adapter.ICatBreedListRowClickListener
import com.test.synchronyapp.utils.DataCallback
import com.test.synchronyapp.viewmodel.CatBreedsListViewModel
import kotlinx.android.synthetic.main.fragment_cat_breeds_list.*
import androidx.fragment.app.FragmentTransaction
import com.test.synchronyapp.ui.HomeActivity


class CatBreedsListFragment : Fragment(), ICatBreedListRowClickListener {
    private lateinit var catBreedListAdapter: CatBreedListAdapter
    private lateinit var catBreedsListViewModel: CatBreedsListViewModel
    private lateinit var noResulttv: TextView
    companion object {
        @JvmStatic
        fun newInstance() =
            CatBreedsListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_cat_breeds_list, container, false)
        noResulttv = view.findViewById<TextView>(R.id.noResulttv)
        initRecyclerView(view)
        onViewModelInit()
        return view
    }


    /**
     * Initialize recyclerview
     * setting the layout manager
     * setting the adapter
     */
    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCatBreeds)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            catBreedListAdapter = CatBreedListAdapter(this@CatBreedsListFragment)
            adapter = catBreedListAdapter
        }
    }

    /**
     * Initialize view model
     */
    private fun onViewModelInit() {
        catBreedsListViewModel = ViewModelProvider(this, object: ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CatBreedsListViewModel(context?.applicationContext as SynchronyApp) as T
            }
        }).get(CatBreedsListViewModel::class.java)

        initCatBreedsListObserver()
    }

    /**
     * Register the observer to get the update from the view model
     */
    private fun initCatBreedsListObserver() {
        catBreedsListViewModel.getCatBreedsListObserver().observe(viewLifecycleOwner, object :
            Observer<DataCallback<CatBreedList>> {
            override fun onChanged(t: DataCallback<CatBreedList>?) {

                when(t?.status) {
                    DataCallback.Status.LOADING -> {
                        showProgressBar()
                    }
                    DataCallback.Status.ERROR -> {
                        hideProgressBar()
                        updateError(getString(R.string.common_error_server_error))
                    }
                    DataCallback.Status.SUCCESS -> {
                        hideProgressBar()
                        catBreedListAdapter.setUpdatedData(t.data!!)
                    } else -> {
                        hideProgressBar()
                        updateError(getString(R.string.common_error_server_error))
                    }
                }
            }
        })
        loadCatsBredList()
    }

    /**
     * Make api call to get Cat breeds list.
     */
    private fun loadCatsBredList() {
        if(catBreedsListViewModel.hasInternetConnection()) {
            catBreedsListViewModel.getCatBreedsList()
        } else {
            updateError(getString(R.string.common_error_no_internet))
        }
    }

    /**
     * Show Error on UI when api don't return result or there are no internet connectivity.
     */
    private fun updateError(error: String) {
        noResulttv.visibility = View.VISIBLE
        noResulttv.text = error
    }

    /**
     * Show progress indicator spinner.
     */
    private fun showProgressBar() {
        progressBar_cyclic.visibility = View.VISIBLE
    }

    /**
     * Hide progress indicator spinner
     */
    private fun hideProgressBar() {
        progressBar_cyclic.visibility = View.GONE
    }

    /**
     * Handle recycler view row click.
     */
    override fun onCatBreedRowClick(catBreedListItem: CatBreedListItem) {
        (activity as HomeActivity).openDetailFragment(catBreedListItem)
    }
}