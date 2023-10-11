package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var textCount : TextView
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this, ViewModelFactory(10))[MainViewModel::class.java]  //.get(MainViewModel::class.java)
        textCount = findViewById(R.id.text)
        setText()
    }
    private fun setText(){
        textCount.text = mainViewModel.count.toString()
    }
    fun increment(v : View){
        mainViewModel.increment()
        setText()
    }
}