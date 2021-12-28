package com.codewars.challenge.web

import com.codewars.challenge.web.result.UserResult
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {
    @get:GET("g964")
    val getUser : Call<UserResult>
}