package com.kotlin.ttnpdev.testadapterandobject.objects

object MultiplyTable {
    private var multiplyTable = ArrayList<String>()

    internal fun retrieveMultiplyTable(table: Int) : ArrayList<*>  {
         for (i in 1 .. 8){
            multiplyTable.add("$table x $i equal "+(table*i))
         }
        return multiplyTable
        // we use array list because we don't need to set default size
    }

}