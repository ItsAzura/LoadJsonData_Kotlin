package com.example.loaddatajson

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loaddatajson.Screen.CharacterViewModel
import com.example.loaddatajson.Screen.MainScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterApp(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                       text = "Character",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            )
        }
    ){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
           val characterViewModel: CharacterViewModel = viewModel(factory = CharacterViewModel.Factory)
            MainScreen(
                characterUiState = characterViewModel.characterUiState ,
                retryAction = characterViewModel::getCharacter,
                modifier = Modifier.fillMaxSize(),
                contentPadding = it,
            )
        }
    }
}