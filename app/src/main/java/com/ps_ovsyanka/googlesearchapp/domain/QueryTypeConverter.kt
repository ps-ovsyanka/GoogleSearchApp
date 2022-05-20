package com.ps_ovsyanka.googlesearchapp.domain;

import androidx.room.TypeConverter
import com.ps_ovsyanka.googlesearchapp.ui.controllers.search.SearchScreenPresenter
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class QueryTypeConverter {
    companion object {
        private const val DATE_FORMAT = "HH:mm dd.MM.yy"
    }
    @TypeConverter
    fun fromDate(date: String): Long? {
        return SimpleDateFormat(DATE_FORMAT).parse(date).time
    }

    @TypeConverter
    fun toStringDate(date: Long): String? {
        return SimpleDateFormat(DATE_FORMAT).format(Date(date))
    }

}
