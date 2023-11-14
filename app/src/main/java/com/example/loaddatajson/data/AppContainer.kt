package com.example.loaddatajson.data

import com.example.loaddatajson.network.CharacterApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val charactersRepository: CharactersRepository
}

class DefaultAppContainer : AppContainer{
    private val base_url="https://genshinlist.com/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(base_url)
        .build()

    private val retrofitService: CharacterApiService by lazy{
        retrofit.create(CharacterApiService::class.java)
    }

    override val charactersRepository: CharactersRepository by lazy{
        DefaultCharactersRepository(retrofitService)
    }

}