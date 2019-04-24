package com.hobodobo.buylist

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hobodobo.buylist.grocery.Grocery
import com.hobodobo.buylist.grocery.GroceryDao

@Database(entities = [Grocery::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun groceryDao(): GroceryDao
}