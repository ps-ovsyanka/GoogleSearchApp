package com.ps_ovsyanka.googlesearchapp.domain

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ps_ovsyanka.googlesearchapp.data.NewTable
import com.ps_ovsyanka.googlesearchapp.data.SavedQuery

@Database(version = 2,
    entities = [SavedQuery::class, NewTable::class],
//    autoMigrations = [AutoMigration(from = 1, to = 2)],
    exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun queryDao() : SavedQueryDao
}

object MIGRATION_1_2 : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.apply {
            try {
                beginTransaction()
                execSQL(
                    "CREATE TABLE NewTable (id INT PRIMARY KEY NOT NULL)"
                )
                setTransactionSuccessful()
            } catch (e: Exception) {
                // Do nothing, just stop the transaction
            } finally {
                endTransaction()
            }
        }
    }
}
