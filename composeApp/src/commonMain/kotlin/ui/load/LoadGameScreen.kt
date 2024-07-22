package ui.load

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import board.Board.Companion.BoardKeyPrefix
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import settings.boardSettings
import ui.game.GameScreenNav

@Composable
fun LoadGameScreen() {
    val navigator = LocalNavigator.currentOrThrow

    val savedGames = remember {
        boardSettings
            .keys
            .filter {
                it.startsWith(BoardKeyPrefix)
            }
            .mapNotNull { key ->
                val encodedPieces = boardSettings.getStringOrNull(key)
                    ?: return@mapNotNull null

                val millis = key
                    .removePrefix(BoardKeyPrefix)
                    .toLongOrNull()
                    ?: return@mapNotNull null

                val date = Instant
                    .fromEpochMilliseconds(millis)
                    .toLocalDateTime(TimeZone.currentSystemDefault())

                date to encodedPieces
            }
            .sortedBy { (date, _) -> date }
    }

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
            if (savedGames.isEmpty())
                Text(
                    text = "No saved games"
                )
            else
                savedGames.forEach { (date, encodedPieces) ->
                    Button(
                        onClick = {
                            navigator.push(GameScreenNav(encodedPieces))
                        }
                    ) {
                        Text(
                            text = "Game $date"
                        )
                    }
                }
        }

        IconButton(
            onClick = {
                navigator.pop()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null
            )
        }
    }
}