package com.example.roomdatabase.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.model.User

//The database class that holds the database and serves as the main access point for the underlying connection to your app's persisted data.
//Data entities that represent tables in your app's database.

@Database(entities = [User::class], version = 1)
abstract class UserDatabase :RoomDatabase(){

    abstract fun userDao(): UserDao

}