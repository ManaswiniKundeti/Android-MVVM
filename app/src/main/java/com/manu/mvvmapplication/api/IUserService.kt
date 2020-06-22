package com.manu.mvvmapplication.api

import com.manu.mvvmapplication.data.User
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

fun createUserService() : IUserService {

    val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(UserServiceMockInterceptor())
        .build()

    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://google.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    return retrofit.create(IUserService::class.java)
}

interface IUserService {

    @GET("user")
    fun getUser(): Call<User>
}