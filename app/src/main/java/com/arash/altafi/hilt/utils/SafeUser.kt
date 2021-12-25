package com.arash.altafi.hilt.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

// use @ApplicationContext to create ApplicationContext

class SafeUser @Inject constructor(@ApplicationContext val context: Context) : user {

    companion object {
        private const val TOKEN_KEY = "name"
    }

    private val pref = context.getSharedPreferences("hilt_test_safe" , Context.MODE_PRIVATE)
    private val editor = pref.edit()

    override fun saveName(name : String) {
        editor.putString(TOKEN_KEY, name)
        editor.apply()
    }

    override fun readName() : String {
        return pref.getString(TOKEN_KEY,"").toString()
    }



}