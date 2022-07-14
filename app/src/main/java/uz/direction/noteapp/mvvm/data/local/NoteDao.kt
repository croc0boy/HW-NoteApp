package uz.direction.noteapp.mvvm.data.local

import androidx.room.*
import uz.direction.noteapp.mvvm.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(vararg note: Note)

    @Update
    fun updateNote(vararg note: Note)

    @Delete
    fun deleteNote(note: Note)

}