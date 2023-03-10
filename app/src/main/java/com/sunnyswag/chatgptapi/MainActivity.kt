package com.sunnyswag.chatgptapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.drakeet.multitype.MultiTypeAdapter
import com.sunnyswag.chatgptapi.databinding.ActivityMainBinding
import com.sunnyswag.chatgptapi.ui.uibinder.ChatHistoryUiBinder
import com.sunnyswag.chatgptapi.ui.uibinder.StartChatUiBinder
import com.sunnyswag.chatgptapi.ui.uimodel.ChatHistoryUiModel
import com.sunnyswag.chatgptapi.ui.uimodel.StartChatUiModel

class MainActivity : AppCompatActivity() {

    private val adapter = MultiTypeAdapter().apply {
        register(StartChatUiModel::class, StartChatUiBinder())
        register(ChatHistoryUiModel::class, ChatHistoryUiBinder())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        initAdapter(binding)
        initPageSelectedListener(binding)
    }

    private fun initPageSelectedListener(binding: ActivityMainBinding) {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_start_chat -> {
                    binding.vpMain.currentItem = START_CHAT_PAGE
                    true
                }
                R.id.nav_chat_history -> {
                    binding.vpMain.currentItem = CHAT_HISTORY_PAGE
                    true
                }
                else -> false
            }
        }

        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    START_CHAT_PAGE -> binding.bottomNavigationView.selectedItemId =
                        R.id.nav_start_chat
                    CHAT_HISTORY_PAGE -> binding.bottomNavigationView.selectedItemId =
                        R.id.nav_chat_history
                }
            }
        })
    }

    private fun initAdapter(binding: ActivityMainBinding) {
        binding.vpMain.adapter = adapter
        adapter.items = listOf(
            StartChatUiModel(),
            ChatHistoryUiModel()
        )
    }

    companion object {
        private const val START_CHAT_PAGE = 0
        private const val CHAT_HISTORY_PAGE = 1
    }
}