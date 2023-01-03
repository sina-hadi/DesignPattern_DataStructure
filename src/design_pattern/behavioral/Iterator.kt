package design_pattern.behavioral

fun main() {

    // Forwards
    val numbers = listOf("one", "two", "three", "four")
    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }

    println("\n<-- NEXT -->\n")

    // Backwards
    val listIterator = numbers.listIterator()
    while (listIterator.hasNext()) listIterator.next()
    println("Iterating backwards:")
    while (listIterator.hasPrevious()) {
        print("Index: ${listIterator.previousIndex()}")
        println(", value: ${listIterator.previous()}")
    }

    println("\n<-- NEXT -->\n")

    // Change
    val numbers2 = mutableListOf("one", "four", "four")
    val mutableListIterator = numbers2.listIterator()

    println("OLD -> $numbers2")
    mutableListIterator.next()
    mutableListIterator.add("two")
    mutableListIterator.next()
    mutableListIterator.set("three")
    println("NEW -> $numbers2")

    println("\n<-- NEXT -->\n")

    printAll(myObj)
}

val myObj = object : Iterator<String> {
    var i = 0

    override fun hasNext(): Boolean {
        return i < 5
    }

    override fun next(): String = when (i) {
        0 -> "On the Front Lines -> "
        else -> "Soldier $i"
    }.also { i++ }
}

fun <T> printAll(iter: Iterator<T>) {
    while (iter.hasNext()) {
        println(iter.next())
    }
}

/**
 * For ->
 * depth-first (also known as depth-first search (DFS))
 * breadth-first (also known as breadth-first search (BFS))
 */