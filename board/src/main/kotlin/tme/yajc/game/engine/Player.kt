package tme.yajc.game.engine

import java.util.concurrent.atomic.AtomicInteger

data class Player(val id: String) {
    companion object {

        private val idGenerator = AtomicInteger(1)

        fun createPlayer(): Player {
            return Player(idGenerator.getAndIncrement().toString())
        }
    }
}