package com.miguelsantos.jediquotations.data

import com.miguelsantos.jediquotations.R
import com.miguelsantos.jediquotations.model.Quotation

class DataSource {

    fun getList(): MutableList<Quotation> {
        val list = mutableListOf(
            Quotation(R.drawable.yoda, "\"Do or do not. There is no try.\" "),
            Quotation(R.drawable.ben, "\"Be mindful of your thoughts, they betray you.\" "),
            Quotation(R.drawable.ben,"\"The truth is often what we make of it; you heard what you wanted to hear, " +
                        "believed what you wanted to believe.\""),
            Quotation(R.drawable.ben,"\"If you strike me down, " +
                    "I shall become more powerful than you can possibly imagine.\""),
            Quotation(R.drawable.ben, "\"If you define yourself by the power to take life, " +
                        "the desire to dominate, to possess…then you have nothing.\""),
            Quotation(R.drawable.yoda, "\"You must unlearn what you have learned.\""),
            Quotation(R.drawable.yoda, "\"Named must be your fear before banish it you can.\""),
            Quotation(R.drawable.yoda, "\"The greatest teacher, failure is.\""),
            Quotation(R.drawable.yoda, "\"Pass on what you have learned.\""),
            Quotation(R.drawable.koon,"\"When You Ask For Trouble, " +
                    "You Should Not Be Surprised If It Finds You.\""),
            Quotation(R.drawable.koon, "\"Your Emotions Are Clouding Your Judgment.\""),
            Quotation(R.drawable.koon, "\"Not Everything Is What It Seems.\"")
        )
        list.shuffle()

        return list
    }

}
