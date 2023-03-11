package com.sunnyswag.chatgptapi.network.model

import com.google.gson.annotations.SerializedName

data class TextCompletionResponse(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("object")
    val objectX: String? = null,

    @SerializedName("created")
    val created: Int? = null,

    @SerializedName("model")
    val model: String? = null,

    @SerializedName("usage")
    val usage: Usage? = null,

    @SerializedName("choices")
    val choices: List<Choice?>? = null
)

data class Choice(
    @SerializedName("message")
    val message: Message? = null,

    @SerializedName("finish_reason")
    val finishReason: String? = null,

    @SerializedName("index")
    val index: Int? = null,
)

data class Message(
    @SerializedName("role")
    val role: String? = null,

    @SerializedName("content")
    val content: String? = null
)
