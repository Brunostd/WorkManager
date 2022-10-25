package com.deny.workmanager

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.deny.workmanager.model.MoviesModel

class MyWorkerB(appContext: Context, workerParameters: WorkerParameters): Worker(appContext,
    workerParameters
) {

    companion object{
        const val KEY_TASK_OUTPUT2: String = "key_task_output"
    }

    var _lista = MutableLiveData<MutableList<MoviesModel>>()
    var lista: LiveData<MutableList<MoviesModel>> = _lista

    override fun doWork(): Result {
        //getMovies()
        var data2 = Data.Builder()
            .putString(KEY_TASK_OUTPUT2, "Task Finished worker B")
            .build()

        return Result.success(data2)
    }

    fun getMovies(){
        //lista = MoviesRepository().getMovies()
    }
}