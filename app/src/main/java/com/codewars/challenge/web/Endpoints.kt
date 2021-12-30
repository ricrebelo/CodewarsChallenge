package com.codewars.challenge.web

import com.codewars.challenge.web.result.ListCompletedChallengesResult
import com.codewars.challenge.web.result.UserResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoints {
    @GET("users/g964")
    fun getSpecificUser() : Call<UserResult>

    @GET("users/{userName}/code-challenges/completed?")
    fun getListCompleteChallenges(
        @Path("userName") userName: String,
        @Query("page") pageSize: Int = 0
    ) : Call<ListCompletedChallengesResult>
}