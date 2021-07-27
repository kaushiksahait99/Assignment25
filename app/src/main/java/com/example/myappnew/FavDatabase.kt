package com.example.myappnew

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Fav::class),version=1,exportSchema = false)
abstract class FavDatabase: RoomDatabase() {
    abstract fun getFavDao():FavDao
    companion object{


        @Volatile
        private var INSTANCE:FavDatabase?=null
        fun getDatabase(context: Context):FavDatabase{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext,FavDatabase::class.java,"Fav_database").build()
                INSTANCE=instance
                /*Creating singleton object named INSTANCE through which we cann access methods defined in dao
                * by calling getFavDao method*/
                instance
            }
        }



    }
}