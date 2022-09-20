package tme.yajc.game.engine

class PlayerStepManager(
    private val players: List<Player>
) {
    private var currentPlayerIndex = 0

    fun currentPlayer(): Player {
        return players[currentPlayerIndex % players.size]
    }

    fun nextPlayer(): Player {
        currentPlayerIndex += 1
        return currentPlayer()
    }
}

