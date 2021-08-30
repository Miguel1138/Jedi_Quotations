package com.miguelsantos.jediquotations.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.miguelsantos.jediquotations.R
import com.miguelsantos.jediquotations.databinding.FragmentQuotationBinding

class QuotationFragment : Fragment() {

    private var bundle: QuotationFragmentArgs? = null
    private lateinit var binding: FragmentQuotationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        bundle = QuotationFragmentArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuotationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bundle?.let {
            (requireActivity() as AppCompatActivity).supportActionBar?.title =
                getString(R.string.quotation_label, it.quotation?.authorName ?: "")
            binding.fragmentAuthorImage.setImageResource(it.quotation?.authorImage ?: -1)
            binding.fragmentQuotationText.text = it.quotation?.quote
        }
    }

}