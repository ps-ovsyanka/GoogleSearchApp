package com.ps_ovsyanka.googlesearchapp.data;

import androidx.room.*
import com.ps_ovsyanka.googlesearchapp.domain.QueryTypeConverter;

@TypeConverters(QueryTypeConverter::class)
@Entity(tableName = "SavedQuery")
class SavedQuery(
        @PrimaryKey(autoGenerate = true)
        var id : Long = 0,
        @field:TypeConverters(QueryTypeConverter::class)
        var query : String,
        var date :String,
        var new: Boolean
        )
