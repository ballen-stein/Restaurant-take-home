package com.affirm.takehome.data

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Restaurant(
    val id: String,
    val name: String,
    val image: String,
    val rating: String
) : Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Restaurant> {
            override fun createFromParcel(parcel: Parcel): Restaurant {
                return Restaurant(parcel)
            }

            override fun newArray(size: Int): Array<Restaurant?> {
                return arrayOfNulls(size)
            }
        }
    }
}
