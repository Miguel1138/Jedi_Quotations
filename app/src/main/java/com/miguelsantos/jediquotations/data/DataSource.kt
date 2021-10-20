package com.miguelsantos.jediquotations.data

import com.miguelsantos.jediquotations.model.Quotation

class DataSource {

    companion object {

        private val _list = mutableListOf<Quotation>()

        fun getList(): MutableList<Quotation> {
            return _list
        }

        fun addQuote(quotation: Quotation) {
            _list.add(0, quotation)
        }

    }

}
