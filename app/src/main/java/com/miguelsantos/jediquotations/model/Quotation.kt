package com.miguelsantos.jediquotations.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class Quotation(
    @DrawableRes val authorImage: Int,
    val quote: String?,
    val authorName: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(authorImage)
        dest?.writeString(quote)
        dest?.writeString(authorName)
    }

    companion object CREATOR : Parcelable.Creator<Quotation> {

        override fun createFromParcel(parcel: Parcel): Quotation = Quotation(parcel)

        override fun newArray(size: Int): Array<Quotation?> = arrayOfNulls(size)

    }

}
