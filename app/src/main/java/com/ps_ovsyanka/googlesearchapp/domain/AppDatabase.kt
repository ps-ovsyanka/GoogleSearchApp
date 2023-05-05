package com.ps_ovsyanka.googlesearchapp.domain

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.ps_ovsyanka.googlesearchapp.data.SavedQuery

@Database(version = 2,
    entities = [SavedQuery::class],
    autoMigrations = [AutoMigration(from = 1, to = 2)],
    exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun queryDao() : SavedQueryDao
}

//object MIGRATION_1_2 : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.apply {
//            try {
//                beginTransaction()
//                execSQL(
//                    "CREATE TABLE FavoriteBonus (id TEXT PRIMARY KEY NOT NULL, clientType TEXT NOT NULL)"
//                )
//                setTransactionSuccessful()
//            } catch (e: Exception) {
//                // Do nothing, just stop the transaction
//            } finally {
//                endTransaction()
//            }
//        }
//    }
//}
