package com.miguelsantos.jediquotations.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.miguelsantos.jediquotations.R
import com.miguelsantos.jediquotations.components.AbstractFragment
import com.miguelsantos.jediquotations.databinding.FragmentCreateNewQuoteBinding
import com.miguelsantos.jediquotations.model.Quotation

class CreateNewQuoteFragment : AbstractFragment() {

    private lateinit var binding: FragmentCreateNewQuoteBinding
    private val getGalleryImage =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            binding.createImageAuthor.setImageURI(it.data?.data)
        }

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
                val intent = Intent(Intent.ACTION_PICK).apply {
                    type = "image/*"
                    flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                }
                getGalleryImage.launch(intent)
            }

            createBtnCreateQuote.setOnClickListener {
                // Removes any quotes mark to prevent doubled quotes or only one quote in the phrase.
                val quote: String = createEdtQuote.text.toString().filter { it != '"' }
                val name: String = createEdtAuthorName.text.toString()

                val quotation = Quotation(
                    createImageAuthor.drawable,
                    String.format(getString(R.string.quote_template), quote),
                    name
                )

                findNavController().navigate(
                    CreateNewQuoteFragmentDirections
                        .actionFragmentNewQuoteToFragmentList(quotation)
                )
            }
        }

    }

}