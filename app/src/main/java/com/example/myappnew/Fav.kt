package com.example.myappnew

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName="Fav_table",indices = [Index(value = ["name","email"], unique = true)])
class Fav(@PrimaryKey val id:Long,@ColumnInfo(name="name")val name:String,@ColumnInfo(name="email")val email:String,@ColumnInfo(name="street")val street:String,@ColumnInfo(name="suite")val suite:String,@ColumnInfo(name="city")val city:String,@ColumnInfo(name="zipcode")val zipcode:String,@ColumnInfo(name="lat")val lat:String,@ColumnInfo(name="lng")val lng:String) {
    /*Creating fields for database(Room)
    model class for room database which will take as an input as constructor parameters
    * when fav icon button is clicked*/
}