package tme.yajc.board.tictactoe

import kotlin.random.Random

fun generateTicTac(
    itemProvider: () -> TicTacItem = ::randomItem
): TicTacToeBoard {
    return TicTacToeBoard().also {
        tme.yajc.board.BoardGenerator.commonGenerator(it, itemProvider)
    }
}

fun randomItem(): TicTacItem {
    return if (Random.nextBoolean()) { // todo is this random thread-local random?
        TicTacCross
    } else {
        TicTacZero
    }
}
