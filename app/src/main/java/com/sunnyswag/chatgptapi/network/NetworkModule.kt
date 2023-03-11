package com.sunnyswag.chatgptapi.network

import com.sunnyswag.chatgptapi.BuildConfig
import com.sunnyswag.chatgptapi.network.dao.OpenAIAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        ).build()

    @Provides
    @Singleton
    fun provideOpenAIAPI(
        okHttpClient: OkHttpClient
    ): OpenAIAPI = Retrofit.Builder()
        .baseUrl(OPEN_AI_API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(OpenAIAPI::class.java)


    private const val OPEN_AI_API_BASE_URL = "https://api.openai.com/v1/"
    const val API_KEY = ""
}
