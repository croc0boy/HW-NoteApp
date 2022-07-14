package uz.direction.noteapp.mvvm.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.direction.noteapp.mvvm.model.Note
import uz.direction.noteapp.mvvm.data.local.NoteDao

class NoteRepositoryImpl(database: NoteDao) : NoteRepository {

    private val noteDB = database

    override suspend fun getAllNotes(): Flow<List<Note>> = flow{
        emit(noteDB.getAllNotes())
    }

    override suspend fun insertNote(note: Note) {
        noteDB.insertNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteDB.updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDB.deleteNote(note)
    }

}