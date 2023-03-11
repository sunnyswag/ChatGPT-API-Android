package com.sunnyswag.chatgptapi.network.dao

import com.sunnyswag.chatgptapi.network.NetworkModule
import com.sunnyswag.chatgptapi.network.model.TextCompletionRequest
import com.sunnyswag.chatgptapi.network.model.TextCompletionResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenAIAPI {

    @POST("chat/completions")
    suspend fun getCompletionsForPrompt(
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Authorization") authToken: String = "Bearer " + NetworkModule.API_KEY,
        @Body textCompletionRequest: TextCompletionRequest
    ): Flow<TextCompletionResponse>
}
