package com.example.loaddatajson.Screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.loaddatajson.CharacterApplication
import com.example.loaddatajson.Model.Character
import com.example.loaddatajson.data.CharactersRepository
import kotlinx.coroutines.launch
import java.io.IOException
import retrofit2.HttpException

sealed interface CharacterUiState{
    data class Success(val characters: List<Character> ):CharacterUiState
    object Error:CharacterUiState
    object Loading: CharacterUiState
}

class CharacterViewModel (private val charactersRepository: CharactersRepository): ViewModel(){
    var characterUiState:CharacterUiState by mutableStateOf(CharacterUiState.Loading)
        private set

    init {
        getCharacter()
    }

    fun getCharacter(){
        viewModelScope.launch {
            characterUiState = CharacterUiState.Loading
            characterUiState = try {
                CharacterUiState.Success(charactersRepository.getCharacters())
            }catch (e: IOException){
                CharacterUiState.Error
            }catch (e: HttpException){
                CharacterUiState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as CharacterApplication)
                val charactersRepository = application.container.charactersRepository
                CharacterViewModel(charactersRepository = charactersRepository)
            }
        }
    }
}