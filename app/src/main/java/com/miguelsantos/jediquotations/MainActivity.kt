package com.miguelsantos.jediquotations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.miguelsantos.jediquotations.data.DataSource
import com.miguelsantos.jediquotations.model.Quotation

class MainActivity : AppCompatActivity() {

    private val mockList: MutableList<Quotation> = DataSource().getList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val recycler: RecyclerView = findViewById(R.id.main_recycler)
        recycler.adapter = QuotationAdapter(mockList)
        recycler.layoutManager = StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)
    }

}