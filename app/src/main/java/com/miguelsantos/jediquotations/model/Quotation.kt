package com.miguelsantos.jediquotations.model

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

data class Quotation(
    val authorImage: Uri,
    val quote: String?,
    val authorName: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Uri::class.java.classLoader) as Uri,
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeValue(authorImage)
        dest?.writeString(quote)
        dest?.writeString(authorName)
    }

    companion object CREATOR : Parcelable.Creator<Quotation> {

        override fun createFromParcel(parcel: Parcel): Quotation = Quotation(parcel)

        override fun newArray(size: Int): Array<Quotation?> = arrayOfNulls(size)

    }


}
