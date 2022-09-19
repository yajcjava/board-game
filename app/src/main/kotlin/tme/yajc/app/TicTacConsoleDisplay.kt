package tme.yajc.app

import tme.yajc.board.tictactoe.TicTacCross
import tme.yajc.board.tictactoe.TicTacToeBoard
import tme.yajc.board.tictactoe.TicTacZero

object TicTacConsoleDisplay : Display<TicTacToeBoard> {
    private val red = "\u001b[31m"
    private val blue = "\u001b[34m"
    private val reset = "\u001b[0m"

    override fun show(board: TicTacToeBoard) {
        print("╔")
        drawLine(board.width)
        println("╗")

        board.mapEachRow { _, items ->
            items.joinToString(" ", "║ ", " ║") {
                val color = when(it) {
                    TicTacZero -> blue
                    TicTacCross -> red
                    null -> ""
                }
                color + (it?.description ?: " ") + reset
            }
        }.forEach { println(it) }

        print("╚")
        drawLine(board.width)
        println("╝")
    }

    private fun drawLine(width: Int) {
        print("═".repeat(width * 2 + 1))
    }
}