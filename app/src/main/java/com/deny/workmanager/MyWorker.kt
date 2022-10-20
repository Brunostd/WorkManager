package com.deny.workmanager

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.deny.workmanager.model.MoviesModel
import com.deny.workmanager.repository.MoviesRepository


class MyWorker(appContext: Context, workerParameters: WorkerParameters): Worker(appContext,
    workerParameters
) {

    companion object{
        const val KEY_TASK_OUTPUT = "key_task_output"
    }

    var _lista = MutableLiveData<MutableList<MoviesModel>>()
    var lista: LiveData<MutableList<MoviesModel>> = _lista

    override fun doWork(): Result {
        getMovies()
        var data1 = Data.Builder()
            .putString(KEY_TASK_OUTPUT, "Task Finished successfuly")
            .build()
        return Result.success()
    }

    fun getMovies(){
        lista = MoviesRepository().getMovies()
    }
}