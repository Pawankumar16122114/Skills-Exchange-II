package com.skillsexchange.app.di

import android.content.Context
import androidx.room.Room
import com.skillsexchange.app.data.database.SkillsExchangeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): SkillsExchangeDatabase {
        return Room.databaseBuilder(
            context,
            SkillsExchangeDatabase::class.java,
            "skills_exchange_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}