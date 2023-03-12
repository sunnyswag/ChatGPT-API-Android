package com.sunnyswag.chatgptapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sunnyswag.chatgptapi.databinding.FragmentChatListBinding

class ChatListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentChatListBinding.inflate(inflater, container, false).root
    }
}