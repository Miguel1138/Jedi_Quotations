package com.miguelsantos.jediquotations.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.miguelsantos.jediquotations.data.DataSource
import com.miguelsantos.jediquotations.databinding.QuotationItemBinding
import com.miguelsantos.jediquotations.model.Quotation
import com.miguelsantos.jediquotations.ui.fragments.ListFragmentDirections

class QuotationAdapter() :
    RecyclerView.Adapter<QuotationAdapter.QuotationViewHolder>() {

    private val list: MutableList<Quotation> = DataSource().getList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = QuotationViewHolder(
        QuotationItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: QuotationViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class QuotationViewHolder(val binding: QuotationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Quotation) {
            with(binding) {
                itemAuthorImage.setImageResource(item.authorImage)
                itemQuotationText.text = item.quote

                itemCardView.setOnClickListener {
                    val action =
                        ListFragmentDirections.actionFragmentListToFragmentQuotation(item)
                    it.findNavController().navigate(action)
                }
            }
        }

    }

}
