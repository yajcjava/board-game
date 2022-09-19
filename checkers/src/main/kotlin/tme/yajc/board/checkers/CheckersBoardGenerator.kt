package tme.yajc.board.checkers

import tme.yajc.board.BoardGenerator
import kotlin.random.Random

fun generateCheckers(
    itemProvider: () -> CheckersItem = ::randomItem
): CheckersBoard = CheckersBoard().also {
    BoardGenerator.commonGenerator(it, itemProvider)
}

fun randomItem(): CheckersItem {
    return if (Random.nextBoolean()) { // todo is this random thread-local random?
        LightCheckersItem(CheckersType.MAN)
    } else {
        DarkCheckersItem(CheckersType.MAN)
    }
}