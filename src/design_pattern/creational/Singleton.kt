package design_pattern.creational

fun main() {

    // Inheritance and OOP
    val myConnection = ConnectionToGreeter()
    myConnection.sayHello()

    println(myConnection.hello)
    println(myConnection.goodBy)
    println(myConnection.sayGoodBy())

    // Singleton
    val a = MyClass()
    val b = MyObject

    println("NEXT")

    val c = MyClass()
    val d = MyObject

    MyObject.addNumber()
    println(MyObject.number)
    MyObject.addNumber()
    val e = MyObject
    println(MyObject.number)

    MyClass.printCompanion()
}

// Singleton
class MyClass() {
    companion object {
        var counter = 0
        fun printCompanion() {
            println("Companion Object")
        }
    }

    init {
        print("init in class -> ")
        println(counter)
        counter++
    }
}

object MyObject {
    init {
        println("init in object")
    }

    var number = 0
    fun addNumber() {
        number++
    }
}

// Inheritance and OOP
class ConnectionToGreeter : Greeter {
    override fun sayHello() {
        println("Hello Mother Fucker")
    }

    override val hello: String
        get() = "Hello"

    override val goodBy: String
        get() = super.goodBy + "Mother Fucker"

}

interface Greeter {
    fun sayHello()

    val hello: String

    fun sayGoodBy(): Int {
        println("Hello")
        return 22
    }

    val goodBy: String
        get() = "GoodBy"
}