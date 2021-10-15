package com.miguelsantos.jediquotations.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.miguelsantos.jediquotations.R
import com.miguelsantos.jediquotations.components.AbstractFragment
import com.miguelsantos.jediquotations.databinding.FragmentQuotationBinding

class QuotationFragment : AbstractFragment() {

    private var bundle: QuotationFragmentArgs? = null
    private lateinit var binding: FragmentQuotationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                val quote = String.format(
                    getString(R.string.send_quote),
                    bundle?.quotation?.authorName,
                    bundle?.quotation?.quote
                )

                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, quote)
                }

                if (activity?.packageManager?.resolveActivity(intent, 0) != null)
                    startActivity(intent)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}