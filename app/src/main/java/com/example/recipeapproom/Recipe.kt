package com.example.recipeapproom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class Recipe (
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")  var id : Int? = null, // this is how can include id if needed
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "instructions") val instructions: String
)