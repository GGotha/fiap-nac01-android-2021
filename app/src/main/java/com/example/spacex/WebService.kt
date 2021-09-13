package com.example.spacex

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface SpaceXAPI {

    @GET("launches/latest")
    fun getLatestLaunch() : Call<Launch>

}

class WebService {
    fun getService() : SpaceXAPI {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SpaceXAPI::class.java)
    }

}