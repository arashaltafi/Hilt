package com.arash.altafi.hilt.workmanagers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.arash.altafi.hilt.utils.Users
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

// @Assisted Meaning ==> hilt never inject, workManager was injects

// use this annotation to say hilt for add this work manager class to hilt
@HiltWorker
class MainWorkManager @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    //hilt inject this because this value not use @Assisted
    private val users: Users
    ) : Worker(context , workerParameters) {

    override fun doWork(): Result {
        Log.e("WorkManager", "Token: " + users.getNames())
        return Result.success()
    }

}