package com.codewars.challenge.web

import com.codewars.challenge.web.result.UserResult
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {
    @get:GET("users/g964")
    val getSpecificUser : Call<UserResult>
}