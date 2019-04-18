package com.hobodobo.buylist

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hobodobo.buylist.grocery.Grocery
import com.hobodobo.buylist.grocery.GroceryDao

@Database(entities = arrayOf(Grocery::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun groceryDao(): GroceryDao
}