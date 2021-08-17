package com.miguelsantos.jediquotations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.miguelsantos.jediquotations.model.Quotation

class QuotationAdapter(private val list: MutableList<Quotation>) :
    RecyclerView.Adapter<QuotationAdapter.QuotationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = QuotationViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.quotation_item, parent, false)
    )

    override fun onBindViewHolder(holder: QuotationViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class QuotationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Quotation) {
            itemView.findViewById<AppCompatImageView>(R.id.item_author_Image)
                .setImageResource(item.authorImage)
            itemView.findViewById<AppCompatTextView>(R.id.item_quotation_text).text = item.quote
        }

    }

}
