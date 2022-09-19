package tme.yajc.board

object BoardGenerator {
    fun <T : Board<R>, R : BoardItem> commonGenerator(
        board: T,
        itemProvider: () -> R
    ): Board<R> {
        board.forEachItem { point, _ ->
            board[point] = itemProvider()
        }
        return board
    }
}