package com.example.loaddatajson.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.loaddatajson.Model.Character
import com.example.loaddatajson.R

@Composable
fun MainScreen(
    characterUiState: CharacterUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when(characterUiState){
        is CharacterUiState.Loading -> LoadingScreen(modifier.size(200.dp))
        is CharacterUiState.Success ->
            CharacterListScreen(
                characters = characterUiState.characters,
                modifier = modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp
                    ),
                contentPadding = contentPadding
                )
        else -> ErrorScreen(retryAction = retryAction, modifier)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading",
        modifier = modifier
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Errol")
        Button(onClick = retryAction) {
            Text("Retry")
        }
    }
}

@Composable
fun CharacterCard(character: Character, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .background(Color.Cyan)
            .padding(
            start = 10.dp,
            bottom = 6.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = modifier
                .background(Color.Cyan)
                .padding(start = 10.dp,
                bottom = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "${character.name} (${character.birthday})",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.White
            )
            Text(
                text = "Gender: ${character.gender}",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Rarity: ${character.rarity} Stars",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "vision: ${character.vision}",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Weapon: ${character.weapon}",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Description: ${character.description}",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )

        }
    }
}

@Composable
private fun CharacterListScreen(
    characters: List<Character>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
  LazyColumn(
      modifier = modifier,
      contentPadding = contentPadding,
      verticalArrangement = Arrangement.spacedBy(24.dp)
  ){
      items(
          items = characters,
          key = {character ->
              character.name
          }
      ){
          CharacterCard(character = it, modifier = Modifier.fillMaxWidth())
      }
  }
}
