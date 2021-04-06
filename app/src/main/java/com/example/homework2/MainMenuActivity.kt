package com.example.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var list = ArrayList<String>()

        val myAdapter = RvAdapter(this, list)


            val btnSend = findViewById<ImageView>(R.id.imSendMessage)
            btnSend.setOnClickListener{

                if (editTextMyMessage.text.isNotEmpty()){

                    list.add(editTextMyMessage.text.toString())
                    list.add("Ты мне")
                    list.add("Два")
                    myAdapter.notifyDataSetChanged()

                }
        }

        my_recycler_view.adapter = RvAdapter(this, list)
        my_recycler_view.layoutManager = LinearLayoutManager(this)

    }
}