package com.ps_ovsyanka.googlesearchapp.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ps_ovsyanka.googlesearchapp.data.SavedQuery

@Database(entities = [SavedQuery::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun queryDao() : SavedQueryDao
}