package com.kotlin.ttnpdev.testadapterandobject.display.services

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.ttnpdev.testadapterandobject.R
import com.kotlin.ttnpdev.testadapterandobject.adapter.ItemOutputMultiplyTable

open class ActivityMultiplyTable : AppCompatActivity () , View.OnClickListener {
    // for getting adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adpRvItems: ItemOutputMultiplyTable
    // for getting adapter
    private lateinit var button : AppCompatButton
    private lateinit var clear : AppCompatButton
    private lateinit var editeTextInputTable: EditText
    // we set textView imageView in adapter class Right?
    // So we don't need to set them in this class
    private fun getWidget() {
        button = findViewById(R.id.buttonMultiplyTable)
        clear = findViewById(R.id.buttonMultiplyTableClear)
    }

    protected fun activityMultiplyTable() {
        getWidget()
        button.setOnClickListener(this@ActivityMultiplyTable)
        clear.setOnClickListener(this@ActivityMultiplyTable)

    }

    private fun getRecycleView(int: Int) {
        recyclerView = findViewById(R.id.recycle_for_multiply_table) // getting the recyclerview by its id
        recyclerView.layoutManager = LinearLayoutManager(this@ActivityMultiplyTable) // this creates a vertical layout Manager
        adpRvItems = ItemOutputMultiplyTable(int)
        recyclerView.adapter = adpRvItems

    }
    override fun onClick(v: View?) {
        when(v?.id) {
            button.id -> {
                editeTextInputTable = findViewById(R.id.editeTextInputTable) // get input
                // Log.i("info", "editeTextInputTable store ${editeTextInputTable.text.toString().toInt()}")
                getRecycleView(validate(editeTextInputTable.text.toString()))
            }
            clear.id -> {
                Log.d("debug", "clear button clicked")
            }
        }
    }
    private fun validate(n : String) : Int {
        var number : Int
        if (n.trim().isNotEmpty()) {
            Log.d("debug", "validate : not be empty")
            number = n.toInt()
        }
        else {
            Log.d("debug", "invalidate : be empty")
            number = 0
        }
        return number
    }
}