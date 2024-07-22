package pieces

import androidx.compose.ui.unit.IntOffset
import chessgamekmp.composeapp.generated.resources.Res
import chessgamekmp.composeapp.generated.resources.knight_black
import chessgamekmp.composeapp.generated.resources.knight_white
import chessgamekmp.composeapp.generated.resources.rook_black
import chessgamekmp.composeapp.generated.resources.rook_white
import org.jetbrains.compose.resources.DrawableResource
import pieces.dsl.getPieceMoves

class Knight(
    override val color: Piece.Color,
    override var position: IntOffset,
): Piece {

    override val type: Char = Type

    override val drawable: DrawableResource =
        if (color.isWhite)
            Res.drawable.knight_white
        else
            Res.drawable.knight_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> =
        getPieceMoves(pieces) {
            getLMoves()
        }

    companion object {
        const val Type = 'N'
    }

}