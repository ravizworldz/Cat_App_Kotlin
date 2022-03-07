package com.test.synchronyapp.ui.adapter

import com.test.synchronyapp.models.CatBreedListItem

interface ICatBreedListRowClickListener {
    fun onCatBreedRowClick(catBreedListItem: CatBreedListItem)
}