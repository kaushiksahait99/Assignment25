package com.example.myappnew

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(fav:Fav)
    @Delete
    suspend fun delete(fav: Fav)



    @Query("Select * from Fav_table")
    fun getAllNotes(): LiveData<List<Fav>>
}