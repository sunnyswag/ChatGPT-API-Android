package com.sunnyswag.chatgptapi.ui.uibinder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.sunnyswag.chatgptapi.R
import com.sunnyswag.chatgptapi.databinding.UiBinderStartChatBinding
import com.sunnyswag.chatgptapi.ui.uimodel.ChatHistoryUiModel

class ChatHistoryUiBinder: ItemViewBinder<ChatHistoryUiModel, ChatHistoryUiBinder.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(UiBinderStartChatBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: ChatHistoryUiModel) {
        Log.d(TAG, "onBindViewHolder: ")
        holder.binding.root.setBackgroundResource(R.color.purple_200)
    }

    inner class ViewHolder(val binding: UiBinderStartChatBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private const val TAG = "ChatHistoryUiBinder"
    }
}