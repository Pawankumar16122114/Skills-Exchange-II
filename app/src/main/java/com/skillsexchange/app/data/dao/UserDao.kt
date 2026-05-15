package com.skillsexchange.app.data.dao

import androidx.room.*
import com.skillsexchange.app.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: String): Flow<User>

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM users ORDER BY rating DESC LIMIT :limit")
    fun getTopRatedUsers(limit: Int): Flow<List<User>>
}