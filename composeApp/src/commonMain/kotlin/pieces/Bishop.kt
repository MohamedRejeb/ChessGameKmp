package pieces

import androidx.compose.ui.unit.IntOffset
import chessgamekmp.composeapp.generated.resources.Res
import chessgamekmp.composeapp.generated.resources.bishop_black
import chessgamekmp.composeapp.generated.resources.bishop_white
import chessgamekmp.composeapp.generated.resources.rook_black
import chessgamekmp.composeapp.generated.resources.rook_white
import org.jetbrains.compose.resources.DrawableResource
import pieces.dsl.getPieceMoves

class Bishop(
    override val color: Piece.Color,
    override var position: IntOffset,
): Piece {

    override val type: Char = Type

    override val drawable: DrawableResource =
        if (color.isWhite)
            Res.drawable.bishop_white
        else
            Res.drawable.bishop_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> =
        getPieceMoves(pieces) {
            diagonalMoves()
        }

    companion object {
        const val Type = 'B'
    }

}