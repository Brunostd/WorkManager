package com.deny.workmanager

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.deny.workmanager.model.MoviesModel

class MainViewModel(val context: Context): ViewModel() {

    /*fun getFilmes(): LiveData<MutableList<MoviesModel>>{
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<MyWorker>()
                .build()
        WorkManager
            .getInstance(context)
            .enqueue(uploadWorkRequest)
    }*/

}