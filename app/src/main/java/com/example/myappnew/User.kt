package com.example.myappnew

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL="https://jsonplaceholder.typicode.com/"
interface User {
    @GET("users")
    fun getDetails(): Call<List<WelcomeElement>>
}
object UserDetails{
    val userinstance:User

    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
             .build()
        userinstance=retrofit.create(User::class.java)
    }
}