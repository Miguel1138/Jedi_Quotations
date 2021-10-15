package com.miguelsantos.jediquotations.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.miguelsantos.jediquotations.R
import com.miguelsantos.jediquotations.components.AbstractFragment
import com.miguelsantos.jediquotations.databinding.FragmentCreateNewQuoteBinding

class CreateNewQuoteFragment : AbstractFragment() {

    private lateinit var binding: FragmentCreateNewQuoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNewQuoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            createImageAuthor.setOnClickListener {
                // TODO: 14/10/2021 Implement search image in storage.
                Toast.makeText(context, "TODO", Toast.LENGTH_SHORT).show()
            }
            createBtnCreateQuote.setOnClickListener {
                // TODO: 14/10/2021 Pegar o valor inserido nos campos e passar via argumento para a
                //  ListFragment.
                // TODO: 14/10/2021 Implement quote string template to insert the quotation marks everytime.
                findNavController().navigate(CreateNewQuoteFragmentDirections.actionFragmentNewQuoteToFragmentList())
            }
        }
    }

}