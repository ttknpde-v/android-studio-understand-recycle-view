package com.kotlin.ttnpdev.testadapterandobject.display

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.ttnpdev.testadapterandobject.R
import com.kotlin.ttnpdev.testadapterandobject.display.services.ActivityMultiplyTable

class MainActivity : ActivityMultiplyTable() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multiply_table_activity)
        activityMultiplyTable()
    }
}