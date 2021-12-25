package com.arash.altafi.hilt.utils

import javax.inject.Inject

// use @Inject to add this class to Hilt

class Users @Inject constructor(private val user: user) {

    fun getNames() : String {
        return user.readName()
    }

    fun saveName(name : String) {
        user.saveName(name)
    }

}