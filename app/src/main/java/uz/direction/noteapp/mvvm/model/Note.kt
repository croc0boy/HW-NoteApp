package uz.direction.noteapp.mvvm.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class Note(
    @ColumnInfo(name = "note", defaultValue = "title")
    val title: String,
    @ColumnInfo(name = "text", defaultValue = "text")
    val text: String,
    @ColumnInfo(name = "date", defaultValue = "12:00")
    val date: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
) : Parcelable
