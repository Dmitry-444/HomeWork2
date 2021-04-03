package com.example.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val intent = Intent()
        val title = getIntent().getStringExtra("hello")
        val user = getIntent().getStringExtra("user")

        tvMessage.text = title
        tvDataOfUser.text = user

    }
}