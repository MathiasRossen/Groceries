package com.hobodobo.buylist.grocery

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GroceryDao {
    @Query("SELECT * FROM Grocery")
    fun getAll(): List<Grocery>

    @Insert
    fun insert(grocery: Grocery)

    @Delete
    fun delete(grocery: Grocery)
}