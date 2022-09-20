/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tme.yajc.app

import tme.yajc.board.checkers.*
import tme.yajc.board.tictactoe.*
import tme.yajc.console.ClearScreen
import tme.yajc.game.engine.GameEngine
import tme.yajc.game.engine.PlayerStepManager
import tme.yajc.game.engine.PlayerStepProvider

fun main() {
    ClearScreen.clearScreen()
//    val board = generateCheckers()
    val board = TicTacToeBoard() //generateTicTac()
    val display = ConsoleDisplay

    val gameEngine = GameEngine(
        board,
        2,
        PlayerStepProvider()
    ) {
        if (it.id == "1") TicTacCross else TicTacZero
    }
    while(!gameEngine.isFinished()) {
        display.show(board,
            drawItem = { it.toLetter() },
            color = { it.toColor() }
        )
        gameEngine.gameStep()
    }
}

fun TicTacItem.toLetter() = when (this) {
    TicTacCross -> "x"
    TicTacZero -> "o"
}

fun TicTacItem.toColor() = when (this) {
    TicTacCross -> Color.RED
    TicTacZero -> Color.BLUE
}

fun CheckersItem.toLetter(): String {
    val letter = when (this) {
        is DarkCheckersItem -> "d"
        is LightCheckersItem -> "l"
    }
    return if (this.type == CheckersType.MAN) letter else letter.uppercase()
}

fun CheckersItem.toColor() = when (this) {
    is DarkCheckersItem -> Color.GREY
    is LightCheckersItem -> Color.RED
}