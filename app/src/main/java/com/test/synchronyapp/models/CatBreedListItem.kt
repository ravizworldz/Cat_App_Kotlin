package com.test.synchronyapp.models

import android.os.Parcel
import android.os.Parcelable

data class CatBreedListItem(
    val adaptability: Int,
    val affection_level: Int,
    val alt_names: String?,
    val bidability: Int,
    val cat_friendly: Int,
    val cfa_url: String?,
    val child_friendly: Int,
    val country_code: String?,
    val country_codes: String?,
    val description: String?,
    val dog_friendly: Int,
    val energy_level: Int,
    val experimental: Int,
    val grooming: Int,
    val hairless: Int,
    val health_issues: Int,
    val hypoallergenic: Int,
    val id: String?,
    val image: Image?,
    val indoor: Int,
    val intelligence: Int,
    val lap: Int,
    val life_span: String?,
    val name: String?,
    val natural: Int,
    val origin: String?,
    val rare: Int,
    val reference_image_id: String?,
    val rex: Int,
    val shedding_level: Int,
    val short_legs: Int,
    val social_needs: Int,
    val stranger_friendly: Int,
    val suppressed_tail: Int,
    val temperament: String?,
    val vcahospitals_url: String?,
    val vetstreet_url: String?,
    val vocalisation: Int,
    val weight: Weight?,
    val wikipedia_url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readParcelable(Image::class.java.classLoader),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readParcelable(Weight::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(adaptability)
        parcel.writeInt(affection_level)
        parcel.writeString(alt_names)
        parcel.writeInt(bidability)
        parcel.writeInt(cat_friendly)
        parcel.writeString(cfa_url)
        parcel.writeInt(child_friendly)
        parcel.writeString(country_code)
        parcel.writeString(country_codes)
        parcel.writeString(description)
        parcel.writeInt(dog_friendly)
        parcel.writeInt(energy_level)
        parcel.writeInt(experimental)
        parcel.writeInt(grooming)
        parcel.writeInt(hairless)
        parcel.writeInt(health_issues)
        parcel.writeInt(hypoallergenic)
        parcel.writeString(id)
        parcel.writeInt(indoor)
        parcel.writeInt(intelligence)
        parcel.writeInt(lap)
        parcel.writeString(life_span)
        parcel.writeString(name)
        parcel.writeInt(natural)
        parcel.writeString(origin)
        parcel.writeInt(rare)
        parcel.writeString(reference_image_id)
        parcel.writeInt(rex)
        parcel.writeInt(shedding_level)
        parcel.writeInt(short_legs)
        parcel.writeInt(social_needs)
        parcel.writeInt(stranger_friendly)
        parcel.writeInt(suppressed_tail)
        parcel.writeString(temperament)
        parcel.writeString(vcahospitals_url)
        parcel.writeString(vetstreet_url)
        parcel.writeInt(vocalisation)
        parcel.writeString(wikipedia_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CatBreedListItem> {
        override fun createFromParcel(parcel: Parcel): CatBreedListItem {
            return CatBreedListItem(parcel)
        }

        override fun newArray(size: Int): Array<CatBreedListItem?> {
            return arrayOfNulls(size)
        }
    }
}