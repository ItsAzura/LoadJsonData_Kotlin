package com.example.loaddatajson.network

import com.example.loaddatajson.Model.Character
import retrofit2.http.GET

interface CharacterApiService {
    @GET("characters")
    suspend fun getCharacters(): List<Character>
}