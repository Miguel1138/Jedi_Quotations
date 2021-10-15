package com.miguelsantos.jediquotations.components

import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.miguelsantos.jediquotations.R

abstract class AbstractFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_new_quote).isVisible = false
    }

}
