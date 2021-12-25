package com.arash.altafi.hilt.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arash.altafi.hilt.R
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit : Retrofit

    @Inject
    lateinit var retrofit2 : Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Navigation Component => see layout


        // Qualifier (Retrofit - arash)
        Log.e("Retrofit", "Activity: 2" + "retrofit 1:" + retrofit.hashCode())
        Log.e("Retrofit", "Activity: 2" + "retrofit 2:" + retrofit2.hashCode())

    }
}