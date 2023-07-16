package com.kotlin.ttnpdev.testadapterandobject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.ttnpdev.testadapterandobject.R
import com.kotlin.ttnpdev.testadapterandobject.entity.MultiplyTableObj
import com.kotlin.ttnpdev.testadapterandobject.objects.MultiplyTable

class ItemOutputMultiplyTable(private val table:Int) : RecyclerView.Adapter<ItemOutputMultiplyTable.MyViewHolder>() {
    private var listMultiplyTableObj = ArrayList<MultiplyTableObj>() // store object list of MultiplyTableObj
    init {
        val multiplyTable = MultiplyTable.retrieveMultiplyTable(table) // store array string :  n * 1 , n * 2 , ... , n * 10
        var multiplyTableObj : MultiplyTableObj
        for (i in 0 .. 7) {
            // Log.d("debug", " multiplyTable ($i) store ${multiplyTable[]}")
            /*
            2023-07-16 15:01:03.565  9211-9211  debug                   com....ttnpdev.testadapterandobject  D   multiplyTable (0) store 3 x 1 equal 3
            2023-07-16 15:01:03.565  9211-9211  debug                   com....ttnpdev.testadapterandobject  D   multiplyTable (1) store 3 x 2 equal 6
            ...
            ..
            2023-07-16 15:01:03.566  9211-9211  debug                   com....ttnpdev.testadapterandobject  D   multiplyTable (9) store 3 x 10 equal 30 
            */
            multiplyTableObj = MultiplyTableObj(R.mipmap.programmer , multiplyTable[i].toString())
            listMultiplyTableObj.add(multiplyTableObj)
        }
        // Log.d("debug", " listMultiplyTableObj 0 store ${listMultiplyTableObj[0]}")
        // debug    com....ttnpdev.testadapterandobject  D   listMultiplyTableObj 0 store MultiplyTableObj(image=2131558403, result='3 x 1 equal 3')
    }
    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var image : ImageView = view.findViewById(R.id.itemImage)
        var result : TextView = view.findViewById(R.id.result_multiply_table)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewRvItemCard = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_output_multiply_tables,parent,false)
        return MyViewHolder(viewRvItemCard)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var multiplyTableObj = listMultiplyTableObj[position]
//        Log.d("debug", " listMultiplyTableObj 0 store ${listMultiplyTableObj[0]}")
//        Log.d("debug", " listMultiplyTableObj 1 store ${listMultiplyTableObj[1]}")
//        Log.d("debug", " listMultiplyTableObj 2 store ${listMultiplyTableObj[2]}")
//        Log.d("debug", " listMultiplyTableObj 3 store ${listMultiplyTableObj[3]}")
//        Log.d("debug", " listMultiplyTableObj 4 store ${listMultiplyTableObj[4]}")
        holder.image.setImageResource(multiplyTableObj.getImage())
        holder.result.text = multiplyTableObj.getResult()

    }
    override fun getItemCount(): Int { // set number for loop in onBindViewHolder()
        return 8
    }
}