package ui.game

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import board.Board
import board.BoardXCoordinates
import board.BoardYCoordinates
import board.rememberIsAvailableMove
import board.rememberPieceAt

@Composable
fun BoardUi(
    board: Board,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .border(
                width = 8.dp,
                color = Color.White
            )
            .padding(8.dp)
    ) {
        BoardYCoordinates
            .forEach { y ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    BoardXCoordinates
                        .forEach { x ->
                            val piece = board.rememberPieceAt(x, y)

                            val isAvailableMove = board.rememberIsAvailableMove(x, y)

                            BoardCell(
                                x = x,
                                y = y,
                                piece = piece,
                                board = board,
                                isAvailableMove = isAvailableMove,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            )
                        }
                }
            }
    }
}