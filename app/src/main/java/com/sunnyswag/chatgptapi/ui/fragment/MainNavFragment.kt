package com.sunnyswag.chatgptapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.sunnyswag.chatgptapi.R
import com.sunnyswag.chatgptapi.databinding.FragmentMainNavBinding
import com.sunnyswag.chatgptapi.ui.adapter.BottomNavigationPagerAdapter

class MainNavFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentMainNavBinding.inflate(inflater, container, false)

        initPageSelectedListener(binding)
        binding.vpMain.adapter = BottomNavigationPagerAdapter(this)

        return binding.root
    }

    private fun initPageSelectedListener(binding: FragmentMainNavBinding) {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_chat_list -> {
                    binding.vpMain.currentItem = BottomNavigationPagerAdapter.CHAT_LIST_PAGE
                    true
                }
                R.id.nav_prompt_chat -> {
                    binding.vpMain.currentItem = BottomNavigationPagerAdapter.PROMPT_CHAT_PAGE
                    true
                }
                else -> false
            }
        }

        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    BottomNavigationPagerAdapter.CHAT_LIST_PAGE -> binding.bottomNavigationView.selectedItemId =
                        R.id.nav_chat_list
                    BottomNavigationPagerAdapter.PROMPT_CHAT_PAGE -> binding.bottomNavigationView.selectedItemId =
                        R.id.nav_prompt_chat
                }
            }
        })
    }
}