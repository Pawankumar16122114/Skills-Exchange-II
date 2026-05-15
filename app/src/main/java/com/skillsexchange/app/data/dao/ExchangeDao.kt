package com.skillsexchange.app.data.dao

import androidx.room.*
import com.skillsexchange.app.data.model.Exchange
import kotlinx.coroutines.flow.Flow

@Dao
interface ExchangeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchange(exchange: Exchange)

    @Update
    suspend fun updateExchange(exchange: Exchange)

    @Delete
    suspend fun deleteExchange(exchange: Exchange)

    @Query("SELECT * FROM exchanges WHERE id = :exchangeId")
    fun getExchangeById(exchangeId: String): Flow<Exchange>

    @Query("SELECT * FROM exchanges WHERE initiatorId = :userId OR recipientId = :userId")
    fun getUserExchanges(userId: String): Flow<List<Exchange>>

    @Query("SELECT * FROM exchanges WHERE status = :status")
    fun getExchangesByStatus(status: String): Flow<List<Exchange>>

    @Query("SELECT * FROM exchanges ORDER BY createdAt DESC")
    fun getAllExchanges(): Flow<List<Exchange>>
}