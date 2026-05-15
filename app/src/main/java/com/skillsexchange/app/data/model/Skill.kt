package com.skillsexchange.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skills")
data class Skill(
    @PrimaryKey
    val id: String,
    val name: String,
    val category: String,
    val description: String? = null,
    val difficulty: String = "Intermediate", // Beginner, Intermediate, Advanced
    val tags: List<String> = emptyList(),
    val createdAt: Long = System.currentTimeMillis()
)
