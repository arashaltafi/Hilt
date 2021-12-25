package com.arash.altafi.hilt.views.fragments

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// use this annotation to say hilt for add this view model class to hilt
@HiltViewModel
class PageViewModel @Inject constructor() : ViewModel() {

    private var counter = 0

    fun addCounter() : Int {
        counter++
        return counter
    }

}