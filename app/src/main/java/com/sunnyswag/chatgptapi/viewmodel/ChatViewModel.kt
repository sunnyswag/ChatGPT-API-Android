package com.sunnyswag.chatgptapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunnyswag.chatgptapi.network.model.Message
import com.sunnyswag.chatgptapi.network.model.TextCompletionRequest
import com.sunnyswag.chatgptapi.network.repository.TextCompletionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val textCompletionRepository: TextCompletionRepository
): ViewModel() {

    fun testTextCompletion() {
        viewModelScope.launch(Dispatchers.IO) {
            textCompletionRepository.getTextCompletionForPrompt(request =
                TextCompletionRequest(
                    messages = listOf(
                        Message(
                            content = "一个有10年Python开发经验的资深算法工程师",
                            role = "system"
                        ),
                        Message(
                            content = "q",
                            role = "user"
                        )
                    )
                )
            )
        }
    }
}