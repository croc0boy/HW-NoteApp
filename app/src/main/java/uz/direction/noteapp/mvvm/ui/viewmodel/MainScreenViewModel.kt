package uz.direction.noteapp.mvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.direction.noteapp.mvvm.model.Note
import uz.direction.noteapp.mvvm.domain.GetAllNotesUseCase

class MainScreenViewModel(
   private val getAllNotesUseCase: GetAllNotesUseCase,
//   private val insertNotesUseCase: InsertNotesUseCase,
//   private val updateNotesUseCase: UpdateNotesUseCase
) : ViewModel() {

   private val _dataFlow = MutableStateFlow(listOf<Note>())
   val dataFlow = _dataFlow.asStateFlow()

   private var _notes = listOf<Note>()
   val notes: List<Note>
      get() = _notes

   fun getAllNotes() = viewModelScope.launch(Dispatchers.IO) {
      _dataFlow.value = notes
      updateNoteAsync().await()
   }

   private suspend fun updateNoteAsync() = viewModelScope.async(Dispatchers.IO) {
      getAllNotesUseCase.execute().collect{ notes ->
         _notes = notes
      }
   }



}