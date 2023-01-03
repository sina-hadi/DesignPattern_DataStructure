package data_structure.linkedlist

fun main() {
    printAndPrintInReverse()
    pushExample()
    appendExample()
    insertExample()
    popExample()
    removeLastExample()
    removeAfterExample()
}

fun printAndPrintInReverse(){
    val list = Node(1,Node(2,Node(3,Node(4,Node(5)))))
    println(list)
    list.printInReverse()
    println()
}

fun pushExample(){
    val list = LinkedList<Int>()
    list.push(3).push(8).push(10).push(16)
    println(list)
}

fun appendExample(){
    val list = LinkedList<Int>()
    list.append(3).append(8).append(10).append(16)
    println(list)
}

fun insertExample(){
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1)
    var middleNode = list.nodeAt(1)!!
    for (i in 1..3){
        middleNode = list.insert(-1 * i, middleNode)
    }
    println(list)
}

fun popExample(){
    val list = LinkedList<Int>()
    list.push(3).push(8).push(10).push(16)
    list.pop()
    println(list)
}

fun removeLastExample(){
    val list = LinkedList<Int>()
    list.push(3).push(8).push(10).push(16)
    list.removeLast()
    println(list)
}

fun removeAfterExample(){
    val list = LinkedList<Int>()
    list.push(3).push(8).push(10).push(16)
    list.removeAfter(list.nodeAt(1)!!)
    println(list)
}