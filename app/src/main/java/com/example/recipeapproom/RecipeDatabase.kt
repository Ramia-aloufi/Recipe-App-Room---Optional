package com.example.notesapproom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipeapproom.Recipe
import com.example.recipeapproom.RecipeDao


@Database(entities = [Recipe::class],version = 1,exportSchema = false)
abstract class RecipeDatabase:RoomDatabase() {

    companion object{
        var instance:RecipeDatabase?=null;
        fun getInstance(ctx: Context):RecipeDatabase
        {
            if(instance!=null)
            {
                return  instance as RecipeDatabase;
            }
            instance= Room.databaseBuilder(ctx,RecipeDatabase::class.java,"raam11").run { allowMainThreadQueries() }.build();
            return instance as RecipeDatabase;
        }
    }
    abstract fun RecipeDao(): RecipeDao;
}