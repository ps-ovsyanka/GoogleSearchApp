package com.ps_ovsyanka.googlesearchapp.ui.di.modules

import android.content.Context
import androidx.room.Room
import com.ps_ovsyanka.googlesearchapp.domain.AppDatabase
import com.ps_ovsyanka.googlesearchapp.domain.MIGRATION_1_2
import com.ps_ovsyanka.googlesearchapp.domain.SavedQueryDao
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class DatabaseModule {
    companion object{
        private val DB_NAME = "database"
    }
    @Provides
    fun providesDao(context : Context) : SavedQueryDao =
        Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .addMigrations(MIGRATION_1_2)
            .build().queryDao()
}