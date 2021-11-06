package com.example.recipeapproom

import androidx.room.*

@Dao
interface RecipeDao {

    @Query("SELECT * FROM Note  ORDER BY id ASC")
    fun getAllUserInfo(): MutableList<Recipe>

    @Insert
    fun insertRecipe(recipe: Recipe)

    @Delete
    fun DeleteRecipe(recipe: Recipe)

    @Update
    fun UpdateRecipe(recipe: Recipe)


}