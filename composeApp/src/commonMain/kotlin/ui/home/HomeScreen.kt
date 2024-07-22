package ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.game.GameScreenNav
import ui.load.LoadGameScreenNav

@Composable
fun HomeScreen() {
    val navigator = LocalNavigator.currentOrThrow

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
        ) {
            Text(
                text = "Chess Game",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navigator.push(GameScreenNav())
                }
            ) {
                Text(
                    text = "New Game"
                )
            }

            Button(
                onClick = {
                    navigator.push(LoadGameScreenNav)
                }
            ) {
                Text(
                    text = "Load Game"
                )
            }
        }
    }
}