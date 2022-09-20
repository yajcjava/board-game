package tme.yajc.game.engine

import tme.yajc.board.Board
import tme.yajc.board.BoardItem
import tme.yajc.console.ClearScreen

class PlayerStepProvider<I: BoardItem, B: Board<I>> {
    fun nextPlayerStep(board: B, boardItem: () -> I) {
        print("Enter coordinates: ")
        val coordinates = readln()
        ClearScreen.clearScreen()
        val (x, y) = coordinates.split(" ").map { it.toInt() }
        val point = x to y
        board[point] = boardItem()
    }
}

enum class PlayerStep {
    PLACE;
}