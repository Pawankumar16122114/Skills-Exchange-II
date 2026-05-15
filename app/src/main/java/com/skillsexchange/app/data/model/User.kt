package com.skillsexchange.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: String,
    val name: String,
    val email: String,
    val profileImage: String? = null,
    val bio: String? = null,
    val skillsOffered: List<String> = emptyList(),
    val skillsWanted: List<String> = emptyList(),
    val rating: Float = 0f,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
