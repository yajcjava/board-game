package tme.yajc.board.tictactoe

import tme.yajc.board.BoardItem

sealed interface TicTacItem : BoardItem

object TicTacZero : TicTacItem {
    override val description: String = "o"

}

object TicTacCross : TicTacItem {
    override val description: String = "x"
}