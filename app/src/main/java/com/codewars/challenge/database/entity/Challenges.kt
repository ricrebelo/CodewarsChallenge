package com.codewars.challenge.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Challenges(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "completedAt") val completedAt: String,
    @ColumnInfo(name = "completedLanguages") val completedLanguages: List<String>,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "slug") val slug: String
)