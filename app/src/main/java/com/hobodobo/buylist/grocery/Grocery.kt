package com.hobodobo.buylist.grocery

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grocery(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    var title: String
)