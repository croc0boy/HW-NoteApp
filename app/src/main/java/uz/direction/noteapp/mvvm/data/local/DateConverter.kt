package uz.direction.noteapp.mvvm.data.local

import androidx.room.TypeConverter
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    @TypeConverter
    fun dateToString(date: Date):String{
        val simpleDateFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
        return simpleDateFormat.format(date)
    }
}