package com.example.recipeapproom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.notesapproom.RecipeDatabase



class MainActivity : AppCompatActivity() {
    lateinit var title: EditText
    lateinit var author: EditText
    lateinit var ingredients: EditText
    lateinit var instructions: EditText
    lateinit var save: Button

    lateinit var view: Button
    lateinit var data:Receipes


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        save.setOnClickListener {

            addtoapi(gettext())

        }
        view.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        title = findViewById(R.id.title)

        author = findViewById(R.id.author)
        ingredients = findViewById(R.id.ingredients)
        instructions = findViewById(R.id.instructions)
        view = findViewById(R.id.View)
        save = findViewById(R.id.Save)
    }

    private fun gettext():Recipe{
        val aa = title.text.toString()
        val bb = author.text.toString()
        val cc = ingredients.text.toString()
        val dd = instructions.text.toString()
        return Recipe(null,aa,bb,cc,dd)



    }

    private fun addtoapi(receipes: Recipe){
        RecipeDatabase.getInstance(this).RecipeDao().insertRecipe(receipes)
        Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
            .show();
    }


}

