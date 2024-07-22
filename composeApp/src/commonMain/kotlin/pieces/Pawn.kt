package pieces

import androidx.compose.ui.unit.IntOffset
import chessgamekmp.composeapp.generated.resources.Res
import chessgamekmp.composeapp.generated.resources.pawn_black
import chessgamekmp.composeapp.generated.resources.pawn_white
import org.jetbrains.compose.resources.DrawableResource
import pieces.dsl.DiagonalMovement
import pieces.dsl.StraightMovement
import pieces.dsl.getPieceMoves

class Pawn(
    override val color: Piece.Color,
    override var position: IntOffset,
): Piece {

    override val type: Char = Type

    override val drawable: DrawableResource =
        if (color.isWhite)
            Res.drawable.pawn_white
        else
            Res.drawable.pawn_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        val isFirstMove =
            position.y == 2 && color.isWhite ||
            position.y == 7 && color.isBlack

        return getPieceMoves(pieces) {
            straightMoves(
                movement = if (color.isWhite) StraightMovement.Up else StraightMovement.Down,
                maxMovements = if (isFirstMove) 2 else 1,
                canCapture = false,
            )

            diagonalMoves(
                movement = if (color.isWhite) DiagonalMovement.UpRight else DiagonalMovement.DownRight,
                maxMovements = 1,
                captureOnly = true,
            )

            diagonalMoves(
                movement = if (color.isWhite) DiagonalMovement.UpLeft else DiagonalMovement.DownLeft,
                maxMovements = 1,
                captureOnly = true,
            )
        }
    }

    companion object {
        const val Type = 'P'
    }

}