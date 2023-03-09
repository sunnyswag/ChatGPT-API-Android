package com.sunnyswag.chatgptapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drakeet.multitype.MultiTypeAdapter
import com.sunnyswag.chatgptapi.databinding.ActivityMainBinding
import com.sunnyswag.chatgptapi.uibinder.ChatHistoryUiBinder
import com.sunnyswag.chatgptapi.uibinder.StartChatUiBinder
import com.sunnyswag.chatgptapi.uimodel.ChatHistoryUiModel
import com.sunnyswag.chatgptapi.uimodel.StartChatUiModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val adapter = MultiTypeAdapter().apply {
        register(StartChatUiModel::class, StartChatUiBinder())
        register(ChatHistoryUiModel::class, ChatHistoryUiBinder())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.vpMain.adapter = adapter
        adapter.items = listOf(
            StartChatUiModel(),
            ChatHistoryUiModel(),
            StartChatUiModel()
        )
    }
}