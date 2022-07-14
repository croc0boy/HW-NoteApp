package uz.direction.noteapp.mvvm.domain

import uz.direction.noteapp.mvvm.model.Note
import uz.direction.noteapp.mvvm.data.repository.NoteRepository

class UpdateNotesUseCase(private val noteRepository: NoteRepository) {
    suspend fun execute(note: Note){
        return noteRepository.updateNote(note)
    }
}