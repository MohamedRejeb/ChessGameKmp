package ui.game

import androidx.compose.runtime.Composable
import board.InitialEncodedPiecesPosition
import board.rememberBoard
import cafe.adriel.voyager.core.screen.Screen

data class GameScreenNav(
    val encodedPieces: String = InitialEncodedPiecesPosition
): Screen {

    @Composable
    override fun Content() {
        val board = rememberBoard(encodedPieces = encodedPieces)

        GameScreen(
            board = board
        )
    }

}