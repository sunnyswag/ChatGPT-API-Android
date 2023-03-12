package com.sunnyswag.chatgptapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sunnyswag.chatgptapi.databinding.ActivityMainBinding
import com.sunnyswag.chatgptapi.ui.adapter.BottomNavigationPagerAdapter
import com.sunnyswag.chatgptapi.ui.adapter.BottomNavigationPagerAdapter.Companion.CHAT_LIST_PAGE
import com.sunnyswag.chatgptapi.ui.adapter.BottomNavigationPagerAdapter.Companion.PROMPT_CHAT_PAGE
import com.sunnyswag.chatgptapi.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val chatViewModel by viewModels<ChatViewModel>()

    private val adapter = BottomNavigationPagerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.vpMain.adapter = adapter
        initPageSelectedListener(binding)
    }

    private fun initPageSelectedListener(binding: ActivityMainBinding) {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_chat_list -> {
                    binding.vpMain.currentItem = CHAT_LIST_PAGE
                    true
                }
                R.id.nav_prompt_chat -> {
                    binding.vpMain.currentItem = PROMPT_CHAT_PAGE
                    true
                }
                else -> false
            }
        }

        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    CHAT_LIST_PAGE -> binding.bottomNavigationView.selectedItemId =
                        R.id.nav_chat_list
                    PROMPT_CHAT_PAGE -> binding.bottomNavigationView.selectedItemId =
                        R.id.nav_prompt_chat
                }
            }
        })
    }
}