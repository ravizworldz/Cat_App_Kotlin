package com.test.synchronyapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.test.synchronyapp.R
import com.test.synchronyapp.models.CatBreedListItem
import kotlinx.android.synthetic.main.fragment_cat_breeds_detail.*
import kotlinx.android.synthetic.main.fragment_cat_breeds_detail.view.*

class CatBreedsDetailFragment : Fragment() {

    private lateinit var childFriendlySection: View
    private lateinit var adaptabilitySection: View
    private lateinit var affectionLevel: View
    private lateinit var dogFriendly: View
    private lateinit var temperamentSection: View
    private lateinit var weightSection: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cat_breeds_detail, container, false)
        childFriendlySection = view.child_friendly_section
        childFriendlySection.findViewById<TextView>(R.id.field_title).text = getString(R.string.cat_detail_Child_Friendly_label)
        adaptabilitySection = view.adaptability_section
        adaptabilitySection.findViewById<TextView>(R.id.field_title).text = getString(R.string.cat_detail_Adaptability_label)
        affectionLevel = view.affection_level_section
        affectionLevel.findViewById<TextView>(R.id.field_title).text = getString(R.string.cat_detail_Affection_label)
        dogFriendly = view.dog_friendly_section
        dogFriendly.findViewById<TextView>(R.id.field_title).text = getString(R.string.cat_detail_Dog_Friendly_label)
        temperamentSection = view.temperament_section
        temperamentSection.findViewById<TextView>(R.id.field_title).text = getString(R.string.cat_detail_Temprament_label)
        weightSection = view.weight_section
        weightSection.findViewById<TextView>(R.id.field_title).text = getString(R.string.cat_detail_Weight_label)

        getSavedArguments(view)
        return view
    }

    /**
     * Set the data to the UI.
     */
    private fun getSavedArguments(view: View) {
        arguments?.getParcelable<CatBreedListItem>("CatBreed")?.let { catBreedItem ->
            childFriendlySection.findViewById<TextView>(R.id.field_description).text = catBreedItem.child_friendly.toString() ?: "--"
            view.findViewById<TextView>(R.id.textviewName).text = catBreedItem.name
            view.findViewById<TextView>(R.id.textviewOrigin).text = String.format(getString(R.string.cat_list_origin), catBreedItem.origin)
            view.findViewById<TextView>(R.id.textviewDescription).text = catBreedItem.description
            val catImageView = view.findViewById<ImageView>(R.id.catImageView)
            adaptabilitySection.findViewById<TextView>(R.id.field_description).text = catBreedItem.adaptability.toString() ?: "--"
            affectionLevel.findViewById<TextView>(R.id.field_description).text = catBreedItem.affection_level.toString() ?: "--"
            dogFriendly.findViewById<TextView>(R.id.field_description).text = catBreedItem.dog_friendly.toString() ?: "--"
            temperamentSection.findViewById<TextView>(R.id.field_description).text = catBreedItem.temperament.toString() ?: "--"
            weightSection.findViewById<TextView>(R.id.field_description).text = catBreedItem.weight?.metric.toString() ?: "--"
            updateCatImage(catBreedItem.image?.url, catImageView)
        }
    }

    /**
     * load the image on card, using glide.
     */
    private fun updateCatImage(url: String?, catImageView: ImageView) {
        Glide.with(catImageView)
            .load(url)
            .centerCrop()
            .into(catImageView)
    }

    companion object {
        @JvmStatic
        fun newInstance(catBreedListItem: CatBreedListItem) =
            CatBreedsDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("CatBreed", catBreedListItem)
                }
            }
    }
}