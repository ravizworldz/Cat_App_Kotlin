package com.test.synchronyapp.ui.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.synchronyapp.R
import com.test.synchronyapp.databinding.CatBreedListRecyclerRowBinding
import com.test.synchronyapp.models.CatBreedListItem

class CatBreedListAdapter(val clickListener: ICatBreedListRowClickListener) : RecyclerView.Adapter<CatBreedListAdapter.SchoolAdapterViewHolder>() {

    private var listData: List<CatBreedListItem>? = null

    fun setUpdatedData(listData: List<CatBreedListItem>) {
        this.listData = listData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SchoolAdapterViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.cat_breed_list_recycler_row, parent, false)
    )

    override fun getItemCount(): Int {
        if(listData == null)return 0
        else return listData?.size!!
    }

    override fun onBindViewHolder(holder: SchoolAdapterViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    inner class SchoolAdapterViewHolder(val view: CatBreedListRecyclerRowBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(data: CatBreedListItem) {
            view.catBreedListItem = data
            view.clickListener = clickListener
            view.executePendingBindings()
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, url: String?) {
            if(!TextUtils.isEmpty(url)) {
                Glide.with(view.context)
                    .load(url)
                    .centerCrop()
                    .into(view)
            }
        }
    }
}