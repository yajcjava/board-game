package tme.yajc.game.engine

import tme.yajc.board.Board
import tme.yajc.board.BoardItem

class GameEngine<I: BoardItem, B: Board<I>>(
    private val board: B,
    private val numberOfPlayers: Int = 2,
    private val playerStepProvider: PlayerStepProvider<I, B>,
    private val playerBoardItem: (Player) -> I
) {
    private val players: List<Player> = (0 until numberOfPlayers).map {
        Player.createPlayer()
    }
    private val playerStepManager: PlayerStepManager = PlayerStepManager(players)

    fun isFinished(): Boolean {
        return false
    }

    fun gameStep() {
        val player = playerStepManager.currentPlayer()
        playerStepProvider.nextPlayerStep(board) {
            playerBoardItem(player)
        }
        playerStepManager.nextPlayer()
    }
}