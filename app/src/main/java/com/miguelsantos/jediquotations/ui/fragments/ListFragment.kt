package com.miguelsantos.jediquotations.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.miguelsantos.jediquotations.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var bundle: ListFragmentArgs? = null
    private lateinit var binding: FragmentListBinding
    private val quotationAdapter = QuotationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: 19/10/2021 Aplicação está duplicando as citações quando muda de tela
        bundle = ListFragmentArgs.fromBundle(requireArguments())
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
        binding.fragmentListRecycler.apply {
            adapter = quotationAdapter
            layoutManager = GridLayoutManager(context, 2)
        }

        // TODO: 19/10/2021 Aplicação está duplicando as citações quando muda de tela
        bundle?.let {
            quotationAdapter.addQuote(it.quotation)
        }
    }

}