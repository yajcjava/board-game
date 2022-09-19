package tme.yajc.board

object BoardGenerator {
    fun <T : Board<R>, R : BoardItem> commonGenerator(
        board: T,
        itemProvider: () -> R
    ): Board<R> {
        (0 until board.height).forEach { x ->
            (0 until board.width).forEach { y ->
                val item = itemProvider()
                board[x to y] = item
            }
        }
        return board
    }
}