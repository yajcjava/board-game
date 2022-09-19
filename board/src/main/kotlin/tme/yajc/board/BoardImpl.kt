package tme.yajc.board



class BoardImpl<T: BoardItem>(
    override val width: Int,
    override val height: Int
) : Board<T> {
    private val fields: MutableMap<Point, T> = mutableMapOf()

    override fun get(point: Point): T? {
        return fields[point]
    }

    override fun set(point: Point, item: T) {
        fields[point] = item
    }

    override fun forEachItem(action: (point: Point, item: T?) -> Unit) {
        (0 until height).forEach { x ->
            (0 until width).forEach { y ->
                val point = x to y
                action(point, fields[point])
            }
        }
    }

    override fun <R> mapEachRow(action: (Int, List<T?>) -> R): List<R> {
        return (0 until height).map { x ->
            val row = (0 until width).map { y ->
                fields[x to y]
            }
            action(x, row)
        }
    }
}

