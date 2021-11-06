package com.example.recipeapproom

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapproom.RecipeDatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var al:MutableList<Recipe>
    lateinit var rv:RecyclerView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        init()

        getReceipees()
        adapt()


        btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun init(){
        al = arrayListOf()
        rv = findViewById(R.id.rv)
        btn = findViewById(R.id.vi)


    }
    private fun getReceipees():MutableList<Recipe> {
       var receipees = RecipeDatabase.getInstance(application).RecipeDao().getAllUserInfo()
        for (i in 0 until receipees.size){
            al.add(receipees.get(i))
        }
        Log.d("receipees","$receipees")
        return receipees
    }
    private fun adapt(){
        rv.adapter = MyAdapter(getReceipees())
        rv.layoutManager = LinearLayoutManager(this)
    }

}
