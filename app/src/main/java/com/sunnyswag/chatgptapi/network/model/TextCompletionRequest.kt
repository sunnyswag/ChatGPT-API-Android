package com.sunnyswag.chatgptapi.network.model

import com.google.gson.annotations.SerializedName

data class TextCompletionRequest(

    @SerializedName("model")
    val model: String = "gpt-3.5-turbo",

    @SerializedName("messages")
    val messages: List<Message>
)
