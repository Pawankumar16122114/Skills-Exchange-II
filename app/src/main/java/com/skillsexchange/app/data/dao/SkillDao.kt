package com.skillsexchange.app.data.dao

import androidx.room.*
import com.skillsexchange.app.data.model.Skill
import kotlinx.coroutines.flow.Flow

@Dao
interface SkillDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkill(skill: Skill)

    @Update
    suspend fun updateSkill(skill: Skill)

    @Delete
    suspend fun deleteSkill(skill: Skill)

    @Query("SELECT * FROM skills WHERE id = :skillId")
    fun getSkillById(skillId: String): Flow<Skill>

    @Query("SELECT * FROM skills WHERE category = :category")
    fun getSkillsByCategory(category: String): Flow<List<Skill>>

    @Query("SELECT * FROM skills")
    fun getAllSkills(): Flow<List<Skill>>

    @Query("SELECT * FROM skills WHERE name LIKE '%' || :query || '%'")
    fun searchSkills(query: String): Flow<List<Skill>>
}