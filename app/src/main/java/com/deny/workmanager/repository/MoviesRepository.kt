package com.deny.workmanager.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deny.workmanager.api.ApiService
import com.deny.workmanager.model.MoviesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepository() {

    private var listMovies = MutableLiveData<MutableList<MoviesModel>>()
    private var auxListMovies: MutableList<MoviesModel> = arrayListOf()

    fun getMovies(): LiveData<MutableList<MoviesModel>>{

        var retrofit = Retrofit.Builder()
            .baseUrl("https://private-b34167-rvmarvel.apiary-mock.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(ApiService::class.java)
        var call: Call<MutableList<MoviesModel>> = service.getFilmes()

        call.enqueue(object : Callback<MutableList<MoviesModel>> {
            override fun onResponse(
                call: Call<MutableList<MoviesModel>>,
                response: Response<MutableList<MoviesModel>>
            ) {
                listMovies.value = response.body()
            }

            override fun onFailure(call: Call<MutableList<MoviesModel>>, t: Throwable) {
                listMovies.value = auxListMovies
            }
        })
        return listMovies
    }

}