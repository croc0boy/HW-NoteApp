package uz.direction.noteapp.mvvm.domain

import kotlinx.coroutines.flow.Flow
import uz.direction.noteapp.mvvm.model.Note
import uz.direction.noteapp.mvvm.data.repository.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {
     suspend fun execute() : Flow<List<Note>>{
        return noteRepository.getAllNotes()
    }
}