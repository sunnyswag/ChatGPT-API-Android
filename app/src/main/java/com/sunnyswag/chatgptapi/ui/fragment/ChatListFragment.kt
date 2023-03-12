package com.sunnyswag.chatgptapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.sunnyswag.chatgptapi.R
import com.sunnyswag.chatgptapi.databinding.FragmentChatListBinding

class ChatListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentChatListBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainNavFragment_to_chatDetailFragment)
        }

        return binding.root
    }
}