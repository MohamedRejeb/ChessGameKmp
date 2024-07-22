package pieces

import androidx.compose.ui.unit.IntOffset
import board.BoardXCoordinates
import board.BoardYCoordinates
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * 1. if is first move be can have 2 movements forward
 * 2. if is not first move be can have 1 movement forward
 * 3. We can capture enemies in diagonal forward
 */
class PawnTest {

    private val demoWhitePiece: Piece =
        Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = BoardXCoordinates.first(),
                y = BoardYCoordinates.first(),
            )
        )

    private val demoBlackPiece: Piece =
        Pawn(
            color = Piece.Color.Black,
            position = IntOffset(
                x = BoardXCoordinates.first(),
                y = BoardYCoordinates.first(),
            )
        )

    // Forward moves

    @Test
    fun testFirstMoveForward() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 2
            )
        )

        val moves = pawn.getAvailableMoves(listOf(pawn))

        assertTrue(moves.isNotEmpty())
        assertEquals(
            IntOffset(
                x = 'A'.code,
                y = 3,
            ),
            moves.first()
        )
    }

    @Test
    fun testSecondMoveForwardTrue() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 2
            )
        )

        val moves = pawn.getAvailableMoves(listOf(pawn))

        assertEquals(2, moves.size)
        assertTrue(
            IntOffset(
                x = 'A'.code,
                y = 3,
            ) in moves
        )
        assertTrue(
            IntOffset(
                x = 'A'.code,
                y = 4,
            ) in moves
        )
    }

    @Test
    fun testSecondMoveForwardFalse() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 3
            )
        )

        val moves = pawn.getAvailableMoves(listOf(pawn))

        assertEquals(1, moves.size)
        assertEquals(
            IntOffset(
                x = 'A'.code,
                y = 4,
            ),
            moves.first()
        )
    }

    @Test
    fun testNoPossibleMoves() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 3
            )
        )
        demoBlackPiece.position =
            IntOffset(
                x = 'A'.code,
                y = 4
            )

        val pieces = listOf(
            pawn,
            demoBlackPiece
        )

        val moves = pawn.getAvailableMoves(pieces)

        assertTrue(moves.isEmpty())
    }

    // Diagonal moves
    @Test
    fun testCaptureEnemy() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 3
            )
        )
        demoBlackPiece.position =
            IntOffset(
                x = 'B'.code,
                y = 4
            )

        val pieces = listOf(
            pawn,
            demoBlackPiece
        )

        val moves = pawn.getAvailableMoves(pieces)

        assertContains(
            moves,
            demoBlackPiece.position
        )
    }

}