package com.deny.workmanager.api

import com.deny.workmanager.model.MoviesModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/saga")
    fun getFilmes(): Call<MutableList<MoviesModel>>

}