package com.codewars.challenge.web

import com.codewars.challenge.web.result.UserResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager private constructor() {

    interface OnWebServiceResult<T> {
        fun getResult(result: WebServiceResult?, response: T?)
    }

    private val BASE_URL = "https://www.codewars.com/api/v1/users/"
    private val serviceCaller: Endpoints

    companion object {
        private var INSTANCE: NetworkManager? = null
        @Synchronized
        fun get(): NetworkManager? {
            if (INSTANCE == null) {
                INSTANCE = NetworkManager()
            }
            return INSTANCE
        }
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        serviceCaller = retrofit.create(Endpoints::class.java)
    }

    fun request(listener: OnWebServiceResult<UserResult>) {
        val response = serviceCaller.getUser
        response.enqueue(MyCallback(listener))
    }

    private class MyCallback<T>(var listener: OnWebServiceResult<T>) : Callback<T> {

        override fun onResponse(call: Call<T>, rawResponse: Response<T>) {
            try {
                listener.getResult(WebServiceResult(
                    isSuccess = true,
                    message = null
                ), rawResponse.body())
            } catch (e: Exception) {
                e.printStackTrace()
                listener.getResult(WebServiceResult(
                    isSuccess = false,
                    message = e.message
                ), null)
            }
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            try {
                listener.getResult(WebServiceResult(
                    isSuccess = false,
                    message = "Failed to download"
                ), null)
            } catch (e: Exception) {
                e.printStackTrace()
                listener.getResult(WebServiceResult(
                    isSuccess = false,
                    message = e.message
                ), null)
            }
        }
    }

    data class WebServiceResult (
        var isSuccess: Boolean = false,
        var message: String? = null
    )
}

