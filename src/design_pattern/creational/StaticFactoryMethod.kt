package design_pattern.creational

fun main() {
    val myClass = StaticFactoryClass.createClass()
    myClass.imInClass()
}

class StaticFactoryClass private constructor() {

    companion object {
        fun createClass(): StaticFactoryClass {
            return StaticFactoryClass()
        }
    }

    fun imInClass() {
        println("I'm in class")
    }
}