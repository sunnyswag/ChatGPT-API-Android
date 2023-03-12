package com.sunnyswag.chatgptapi.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunnyswag.chatgptapi.ui.fragment.ChatListFragment
import com.sunnyswag.chatgptapi.ui.fragment.PromptChatFragment

class BottomNavigationPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return BOTTOM_NAVIGATION_PAGE_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            CHAT_LIST_PAGE -> return ChatListFragment()
            PROMPT_CHAT_PAGE -> return PromptChatFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    companion object {
        const val BOTTOM_NAVIGATION_PAGE_COUNT = 2
        const val CHAT_LIST_PAGE = 0
        const val PROMPT_CHAT_PAGE = 1
    }
}