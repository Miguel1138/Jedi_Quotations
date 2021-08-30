package com.miguelsantos.jediquotations.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.miguelsantos.jediquotations.R
import com.miguelsantos.jediquotations.data.DataSource
import com.miguelsantos.jediquotations.databinding.FragmentListBinding
import com.miguelsantos.jediquotations.model.Quotation
import com.miguelsantos.jediquotations.ui.QuotationAdapter

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler: RecyclerView = binding.fragmentListRecycler
        recycler.adapter = QuotationAdapter()
        recycler.layoutManager = GridLayoutManager(context, 2)
    }

}