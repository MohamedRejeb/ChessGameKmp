package pieces

import androidx.compose.ui.unit.IntOffset
import chessgamekmp.composeapp.generated.resources.Res
import chessgamekmp.composeapp.generated.resources.queen_black
import chessgamekmp.composeapp.generated.resources.queen_white
import org.jetbrains.compose.resources.DrawableResource
import pieces.dsl.getPieceMoves

class Queen(
    override val color: Piece.Color,
    override var position: IntOffset,
): Piece {

    override val type: Char = Type

    override val drawable: DrawableResource =
        if (color.isWhite)
            Res.drawable.queen_white
        else
            Res.drawable.queen_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> =
        getPieceMoves(pieces) {
            straightMoves()
            diagonalMoves()
        }

    companion object {
        const val Type = 'Q'
    }

}