package uz.direction.noteapp.mvvm.data.repository

import kotlinx.coroutines.flow.Flow
import uz.direction.noteapp.mvvm.model.Note

interface NoteRepository {
    suspend fun getAllNotes(): Flow<List<Note>>
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
}