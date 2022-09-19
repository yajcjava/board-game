package tme.yajc.board.tictactoe

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class TicTacToeBoardTest {

    @TestFactory
    fun testWholeBoardContains() = listOf(TicTacZero, TicTacCross).map { testItem ->
        DynamicTest.dynamicTest(testItem.description) {
            val board = generateTicTac { testItem }
            board.forEachItem { _, boardItem ->
                assertEquals(testItem, boardItem)
            }
        }
    }

    @Test
    fun testEmptyBoard() {
        val board = TicTacToeBoard()
        board.forEachItem { _, item ->
            assertNull(item)
        }
    }
}