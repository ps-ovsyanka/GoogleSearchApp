package com.ps_ovsyanka.googlesearchapp.domain

import androidx.room.*
import com.ps_ovsyanka.googlesearchapp.data.SavedQuery

@Dao
interface SavedQueryDao {

    @Insert
    suspend fun insert(query : SavedQuery)

    @Delete
    suspend fun delete(query : SavedQuery)

    @Update
    suspend fun update(query : SavedQuery)

    @Query("select distinct `query`  from (select * from SavedQuery order by id desc) limit 5")
    suspend fun getStringQuery() : List<String>

    @Query("select * from SavedQuery")
    suspend fun getAllQuery() : List<SavedQuery>
}