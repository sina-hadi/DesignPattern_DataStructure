package design_pattern.behavioral

fun main() {
    val pepperoni = Pepperoni()
    val bigPepperoni = BigPepperoni()

    print("Make Pepperoni -> \n")
    pepperoni.make()
    print("\nMake Big Pepperoni -> \n")
    bigPepperoni.make()

}

abstract class Pizza {

    fun make() {
        makeDough()
        applySauce()
        addIngredients()
        bake()
    }

    open fun bake() {
        println("baking for 20 minutes")
    }

    open fun addIngredients() {
        println("adding cheese")
    }

    open fun applySauce() {
        println("applying tomato sauce")
    }

    open fun makeDough() {
        println("making 30cm dough")
    }
}

class Pepperoni : Pizza() {
    override fun addIngredients() {
        println("adding salami")
        println("adding onion")
        println("adding cheese")
    }

}

class BigPepperoni : Pizza() {

    override fun addIngredients() {
        println("adding salami")
        println("adding onion")
        println("adding cheese")
    }

    override fun makeDough() {
        println("making 50cm dough")
    }
}
