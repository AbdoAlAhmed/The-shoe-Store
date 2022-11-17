package com.abdo.theshoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {


    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    private val _addSuccessEvent = MutableLiveData<Boolean>()
    val addSuccessEvent: LiveData<Boolean>
        get() = _addSuccessEvent

    // initialize data and set event false
    init {
        _addSuccessEvent.value = false

        _shoeList.value = arrayListOf(
            Shoe("Nike","45","cool and fun ", "nike")
        )
    }

    // Method add new shoe
    fun addShoe(shoe: Shoe) {
        val shoeName = shoe.shoeName ?: " "
        val shoeSize = shoe.shoeSize ?: " "
        val company = shoe.company ?: " "
        val description = shoe.description ?: " "
        _shoeList.value?.add(Shoe(shoeName,shoeSize,company,description))

        Log.i("TAG",_shoeList.value.toString())
        // change event to true
        _addSuccessEvent.value = true
    }

    // Method for complete add shoe
    fun addSuccess() {
        _addSuccessEvent.value = false
    }

}


