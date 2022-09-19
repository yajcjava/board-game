package tme.yajc.board.checkers

import tme.yajc.board.BoardItem

enum class CheckersColor {
    LIGHT,
    DARK
}

enum class CheckersType {
    MAN,
    KING
}

sealed interface CheckersItem : BoardItem {
    val color: CheckersColor
    val type: CheckersType
}

class LightCheckersItem(override val type: CheckersType) : CheckersItem {
    override val color: CheckersColor = CheckersColor.LIGHT
    override val description: String = color.name
}

class DarkCheckersItem(override val type: CheckersType) : CheckersItem {
    override val color: CheckersColor = CheckersColor.DARK
    override val description: String = color.name
}