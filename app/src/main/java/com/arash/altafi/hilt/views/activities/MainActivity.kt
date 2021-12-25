package com.arash.altafi.hilt.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.arash.altafi.hilt.R
import com.arash.altafi.hilt.di.qualifiers.ArashRetrofit
import com.arash.altafi.hilt.viewmodels.MainViewModel
import com.arash.altafi.hilt.workmanagers.MainWorkManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // view model
    private val viewModel : MainViewModel by viewModels()

    // Retrofit
    @Inject
    lateinit var retrofit : Retrofit

    // Qualifier (Retrofit - arash) ===> (for create 2 instance from one dependency)
    @Inject
    @ArashRetrofit
    lateinit var retrofit2 : Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Save Name
        viewModel.saveName("Arash Altafi")

        //Get Name
        btn_name.setOnClickListener {
            Toast.makeText(this , viewModel.getNames() , Toast.LENGTH_LONG).show()
        }

        // Go To Second Activity For See Log (Scoped)
        btn_secondActivity.setOnClickListener {
            startActivity(Intent(this , SecondActivity::class.java))
        }

        // Qualifier (Retrofit - arash)
        Log.e("Retrofit", "Activity: 1" + "retrofit 1:" + retrofit.hashCode() + " url:" + retrofit.baseUrl())
        Log.e("Retrofit", "Activity: 1" + "retrofit 2:" + retrofit2.hashCode() + " url:" + retrofit2.baseUrl())


        //View Model
        btn_viewModel.setOnClickListener {
            Toast.makeText(this , "counter - view model : " + viewModel.addCounter() , Toast.LENGTH_SHORT).show()
        }

        // Work Manager
        configWorkManager()

    }

    // Work Manager
    private fun configWorkManager() {
        val reqWork : PeriodicWorkRequest = PeriodicWorkRequestBuilder<MainWorkManager>(5 , TimeUnit.HOURS).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork("main_worker" , ExistingPeriodicWorkPolicy.KEEP , reqWork)
    }

}
