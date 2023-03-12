package com.sunnyswag.chatgptapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunnyswag.chatgptapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }

}