package com.example.loaddatajson.data

import com.example.loaddatajson.Model.Character
import com.example.loaddatajson.network.CharacterApiService

interface CharactersRepository{
    suspend fun getCharacters(): List<Character>
}

class DefaultCharactersRepository(
    private val charactersApiService: CharacterApiService
) : CharactersRepository
{
    override suspend fun getCharacters(): List<Character> {
        return charactersApiService.getCharacters()
    }
}