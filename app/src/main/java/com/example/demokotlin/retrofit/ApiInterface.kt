package com.example.demokotlin.retrofit

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/public/version/android")
    fun getCurrency(): Observable<BaseResponse>

    fun getSomething(): Call<BaseResponse>
}