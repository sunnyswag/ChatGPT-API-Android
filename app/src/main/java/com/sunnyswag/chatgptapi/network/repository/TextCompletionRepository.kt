package com.sunnyswag.chatgptapi.network.repository

import com.sunnyswag.chatgptapi.network.dao.OpenAIAPI
import com.sunnyswag.chatgptapi.network.model.TextCompletionRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextCompletionRepository @Inject constructor(
    private val openAIAPI: OpenAIAPI
) {

    suspend fun getTextCompletionForPrompt(
        request: TextCompletionRequest
    ) = openAIAPI.getCompletionsForPrompt(textCompletionRequest = request)
        .flowOn(Dispatchers.IO)
}
