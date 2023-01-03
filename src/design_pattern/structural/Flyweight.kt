package design_pattern.structural

// WARNING NOT SURE -> RESEARCH //

fun main() {
    val newSnail = TansanianSnail()
    newSnail.getCurrentSprite(sprites)
}

class TansanianSnail() {
    val directionFacing = Direction.LEFT
    val sprites = listOf(
        java.io.File("snail-left.jpg"),
        java.io.File("snail-right.jpg")
    )
}

// Pass as a constructor not calculate every time
fun TansanianSnail.getCurrentSprite(sprites: List<java.io.File>): java.io.File {
    return when (directionFacing) {
        Direction.LEFT -> sprites[0]
        Direction.RIGHT -> sprites[1]
    }
}

val sprites = List(8) { i ->
    java.io.File(
        when (i) {
            0 -> "snail-left.jpg"
            1 -> "snail-right.jpg"
            in 2..4 -> "snail-move-left-${i - 1}.jpg"
            else -> "snail-move-right${(4 - i)}.jpg"
        }
    )
}

enum class Direction {
    LEFT,
    RIGHT
}

/**
 * Use less memory in this design pattern
 * pass a variable as a constructor of a
 * function that is connect to the class
 */