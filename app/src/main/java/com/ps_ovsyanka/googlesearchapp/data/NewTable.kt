package com.ps_ovsyanka.googlesearchapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewTable")
data class NewTable(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
)