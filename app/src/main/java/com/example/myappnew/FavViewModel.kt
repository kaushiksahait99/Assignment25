package com.example.myappnew

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavViewModel(application: Application) : AndroidViewModel(application) {
    val allFav: LiveData<List<Fav>>
    private val repository:FavRepository
    init {
        val dao=FavDatabase.getDatabase(application).getFavDao()
        repository=FavRepository(dao)
        allFav=repository.allFav
    }
    fun InsertNote(fav: Fav)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(fav)
    }
    fun deleteNote(fav:Fav )=viewModelScope.launch(Dispatchers.IO) {
        repository.delete(fav)
    }

}