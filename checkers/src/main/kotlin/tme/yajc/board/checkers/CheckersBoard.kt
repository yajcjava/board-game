package tme.yajc.board.checkers

import tme.yajc.board.Board
import tme.yajc.board.BoardImpl

class CheckersBoard: Board<CheckersItem> by BoardImpl(8, 8)