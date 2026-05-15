package com.skillsexchange.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.skillsexchange.app.data.dao.ExchangeDao
import com.skillsexchange.app.data.dao.SkillDao
import com.skillsexchange.app.data.dao.UserDao
import com.skillsexchange.app.data.model.Exchange
import com.skillsexchange.app.data.model.Skill
import com.skillsexchange.app.data.model.User

@Database(
    entities = [User::class, Skill::class, Exchange::class],
    version = 1,
    exportSchema = false
)
abstract class SkillsExchangeDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun skillDao(): SkillDao
    abstract fun exchangeDao(): ExchangeDao

    companion object {
        @Volatile
        private var INSTANCE: SkillsExchangeDatabase? = null

        fun getInstance(context: Context): SkillsExchangeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SkillsExchangeDatabase::class.java,
                    "skills_exchange_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}