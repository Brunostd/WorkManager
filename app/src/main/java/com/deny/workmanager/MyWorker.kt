package com.deny.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, workerParameters: WorkerParameters): Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}