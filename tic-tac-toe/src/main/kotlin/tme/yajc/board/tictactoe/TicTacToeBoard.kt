package tme.yajc.board.tictactoe

import tme.yajc.board.Board
import tme.yajc.board.BoardImpl

class TicTacToeBoard: Board<TicTacItem> by BoardImpl(3, 3) {
}