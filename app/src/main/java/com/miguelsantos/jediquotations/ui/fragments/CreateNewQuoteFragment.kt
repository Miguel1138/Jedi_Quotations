package com.miguelsantos.jediquotations.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.miguelsantos.jediquotations.R
import com.miguelsantos.jediquotations.components.AbstractFragment
import com.miguelsantos.jediquotations.data.DataSource
import com.miguelsantos.jediquotations.databinding.FragmentCreateNewQuoteBinding
import com.miguelsantos.jediquotations.model.Quotation

class CreateNewQuoteFragment : AbstractFragment() {

    private var image: String? = null
    private lateinit var binding: FragmentCreateNewQuoteBinding

    private val getGalleryImage =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            image = it.data?.data.toString()
            Glide.with(this).load(image).into(binding.createImageAuthor)
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

                // TODO: 20/10/2021
                //  UninitializedPropertyAccessException: lateinit property image has not been initialized
                // Error Occurs when try to pass a quote without image.
                // For now passing a empty String.
                val quotation = Quotation(
                    Uri.parse(image ?: ""),
                    String.format(getString(R.string.quote_template), quote),
                    name
                )

                // Future viewModel call
                DataSource.addQuote(quotation)

                findNavController().navigate(CreateNewQuoteFragmentDirections.actionFragmentNewQuoteToFragmentList())
            }
        }

    }

}