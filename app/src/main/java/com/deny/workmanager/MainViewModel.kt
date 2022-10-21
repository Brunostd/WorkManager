package com.deny.workmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.deny.workmanager.model.MoviesModel
import com.deny.workmanager.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MainViewModel(application: Application): AndroidViewModel(application) {

    lateinit var aux: LiveData<MutableList<MoviesModel>>

    suspend fun getMovies(): LiveData<MutableList<MoviesModel>> {
        return withContext(Dispatchers.IO) {
            MoviesRepository().getMovies()
        }
    }
    /*suspend fun getMovies() {
        viewModelScope.async(Dispatchers.IO){
            aux = MoviesRepository().getMovies()
        }.await()
    }*/

    suspend fun getDirector(): LiveData<MutableList<MoviesModel>> {
        return withContext(Dispatchers.IO) {
            MoviesRepository().getMovies()
        }
    }
}