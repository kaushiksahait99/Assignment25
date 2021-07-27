package com.example.myappnew

import androidx.lifecycle.LiveData

class FavRepository(private val favDao: FavDao) {
    val allFav: LiveData<List<Fav>> = favDao.getAllNotes()
    suspend fun insert(fav: Fav){
        favDao.insert(fav)
    }
    suspend fun delete(fav: Fav){
        favDao.delete(fav)
    }

}