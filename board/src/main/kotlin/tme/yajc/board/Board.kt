package tme.yajc.board

typealias Point = Pair<Int, Int>

interface Board<T: BoardItem> {
    val width: Int
    val height: Int

    operator fun get(point: Point): T?
    operator fun set(point: Point, item: T)

    fun forEachItem(action: (point: Point, item: T?) -> Unit)
    fun <R> mapEachRow(action: (row: Int, items: List<T?>) -> R): List<R>
}