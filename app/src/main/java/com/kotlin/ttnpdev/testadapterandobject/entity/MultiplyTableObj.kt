package com.kotlin.ttnpdev.testadapterandobject.entity

class MultiplyTableObj (private var image:Int, private var result:String){
    internal fun getImage() :Int {
        return image
    }
    internal fun getResult() :String {
        return result
    }

    override fun toString(): String {
        return "MultiplyTableObj(image=$image, result='$result')"
    }

}