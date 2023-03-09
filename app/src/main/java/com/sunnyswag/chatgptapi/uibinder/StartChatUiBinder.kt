package com.sunnyswag.chatgptapi.uibinder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.sunnyswag.chatgptapi.R
import com.sunnyswag.chatgptapi.databinding.UiBinderStartChatBinding
import com.sunnyswag.chatgptapi.uimodel.StartChatUiModel

class StartChatUiBinder: ItemViewBinder<StartChatUiModel, StartChatUiBinder.ViewHolder>() {


    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(UiBinderStartChatBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: StartChatUiModel) {
        Log.d(TAG, "onBindViewHolder: ")
        holder.binding.root.setBackgroundResource(R.color.black)
    }

    inner class ViewHolder(val binding: UiBinderStartChatBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private const val TAG = "StartChatUiBinder"
    }
}