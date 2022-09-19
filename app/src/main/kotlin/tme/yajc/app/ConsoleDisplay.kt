package tme.yajc.app

import tme.yajc.board.Board
import tme.yajc.board.BoardItem

enum class Color(val str: String) {
    RED("\u001b[31m"),
    BLUE("\u001b[34m"),
    GREY("\u001b[37m");
}

object ConsoleDisplay : Display {

    private val reset = "\u001b[0m"

    fun <T: BoardItem> show(
        board: Board<T>,
        drawItem: (T) -> String,
        color: (T) -> Color
    ) {
        print("╔")
        drawLine(board.width)
        println("╗")

        board.mapEachRow { _, items ->
            items.joinToString(" ", "║ ", " ║") { item ->
                item?.let {
                    color(it).str + drawItem(it) + reset
                } ?: " "
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