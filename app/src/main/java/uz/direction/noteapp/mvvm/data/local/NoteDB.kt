package uz.direction.noteapp.mvvm.data.local

import androidx.room.*
import uz.direction.noteapp.mvvm.model.Note
import uz.direction.noteapp.mvvm.util.App

@Database(entities = [Note::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class NoteDB : RoomDatabase() {

    abstract fun getDao(): NoteDao

    companion object {
        private var instance: NoteDB? = null

        fun getDatabaseInstance() : NoteDB {
            return instance ?: Room.databaseBuilder(
                App.getContext(),
                NoteDB::class.java, "note_db"
            )
                .fallbackToDestructiveMigration()
                .build().also {
                    instance = it
                }

        }
    }
}