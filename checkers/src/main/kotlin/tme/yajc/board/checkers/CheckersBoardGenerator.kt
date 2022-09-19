package tme.yajc.board.checkers

import tme.yajc.board.BoardGenerator
import kotlin.random.Random

fun generateCheckers(
    itemProvider: () -> CheckersItem = ::randomItem
): CheckersBoard = CheckersBoard().also {
    BoardGenerator.commonGenerator(it, itemProvider)
}

fun randomItem(): CheckersItem {
    val type = if (Random.nextBoolean()) {
        CheckersType.MAN
    } else {
        CheckersType.KING
    }
    return if (Random.nextBoolean()) { // todo is this random thread-local random?
        LightCheckersItem(type)
    } else {
        DarkCheckersItem(type)
    }
}