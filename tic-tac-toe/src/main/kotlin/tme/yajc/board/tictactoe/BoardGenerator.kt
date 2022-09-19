package tme.yajc.board.tictactoe

import kotlin.random.Random

object BoardGenerator {
    fun generate(
        itemProvider: () -> TicTacItem = ::randomItem
    ): TicTacToeBoard {
        val board = TicTacToeBoard()
        (0 until board.height).forEach { x ->
            (0 until board.width).forEach { y ->
                val item = itemProvider()
                board[x to y] = item
            }
        }
        return board
    }

    private fun randomItem(): TicTacItem {
        return if (Random.nextBoolean()) { // todo is this random thread-local random?
            TicTacCross
        } else {
            TicTacZero
        }
    }
}