package com.arash.altafi.hilt.viewmodels

import androidx.lifecycle.ViewModel
import com.arash.altafi.hilt.utils.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// use  @Inject constructor() to add values to hilt

// use this annotation to say hilt for add this view model class to hilt
@HiltViewModel
class MainViewModel @Inject constructor(private val users: Users) : ViewModel() {

    private var counter = 0

    fun addCounter() : Int {
        counter++
        return counter
    }

    fun saveName(name : String) {
        users.saveName(name)
    }

    fun getNames() : String {
        return users.getNames()
    }

}