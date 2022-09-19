package tme.yajc.app

import tme.yajc.board.Board
import tme.yajc.board.BoardItem

interface Display<B: Board<out BoardItem>> {
    fun show(board: B)
}