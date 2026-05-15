package com.skillsexchange.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchanges")
data class Exchange(
    @PrimaryKey
    val id: String,
    val initiatorId: String,
    val recipientId: String,
    val initiatorSkillId: String,
    val recipientSkillId: String,
    val status: String = "PENDING", // PENDING, ACCEPTED, COMPLETED, REJECTED, CANCELLED
    val scheduledDate: Long? = null,
    val rating: Int? = null,
    val feedback: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
