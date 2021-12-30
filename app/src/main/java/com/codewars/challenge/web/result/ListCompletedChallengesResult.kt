package com.codewars.challenge.web.result


import com.google.gson.annotations.SerializedName

data class ListCompletedChallengesResult(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Int
) {
    data class Data(
        @SerializedName("completedAt")
        val completedAt: String,
        @SerializedName("completedLanguages")
        val completedLanguages: List<String>,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("slug")
        val slug: String
    )
}