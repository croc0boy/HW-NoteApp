package uz.direction.noteapp.mvvm.util


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.direction.noteapp.mvvm.data.local.NoteDB
import uz.direction.noteapp.mvvm.data.repository.NoteRepositoryImpl
import uz.direction.noteapp.mvvm.domain.GetAllNotesUseCase
import uz.direction.noteapp.mvvm.ui.viewmodel.MainScreenViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val factRepository = NoteRepositoryImpl(
            NoteDB.getDatabaseInstance().getDao()
        )
        return MainScreenViewModel(
            GetAllNotesUseCase(factRepository)
        ) as T
    }
}