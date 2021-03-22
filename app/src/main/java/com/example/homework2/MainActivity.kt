package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, firstFragment)
        transaction.commit()

    }
}