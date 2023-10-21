package com.example.crick_r

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApliClient
{
    companion object
    {
        var BASE_URL = "https://sahiltops3939.000webhostapp.com/API/Data/"
        lateinit var retrofit: Retrofit

        fun getapiclient(): Retrofit
        {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }
    }
}