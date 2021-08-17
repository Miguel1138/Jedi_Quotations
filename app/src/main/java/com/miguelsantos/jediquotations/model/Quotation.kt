package com.miguelsantos.jediquotations.model

import androidx.annotation.DrawableRes

data class Quotation(
    @DrawableRes val authorImage: Int,
    val quote: String
)
