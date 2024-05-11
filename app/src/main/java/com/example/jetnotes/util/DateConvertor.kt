package com.example.jetnotes.util

import androidx.room.TypeConverter
import java.sql.Time
import java.sql.Timestamp
import java.util.Date

class DateConvertor {
    @TypeConverter
    fun timeStampFromDate(date : Date):Long{
        return date.time

    }
    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long):Date?{
        return Date(timestamp)
    }
}