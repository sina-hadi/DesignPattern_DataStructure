package design_pattern.structural

// FIRST SAMPLE

fun main() {

    // FIRST SAMPLE
    val happy = HappyMap<String, String>()
    happy["one"] = "one"
    happy["two"] = "two"
    happy["two"] = "three"
    happy["one"] = "four"
    happy["two"] = "three"

    println("<-- NEXT -->")

    val sadHappy = SadHappyMap(SadMap<String, String>())
    sadHappy["one"] = "one"
    sadHappy["two"] = "two"
    sadHappy["two"] = "three"
    sadHappy["a"] = "b"
    sadHappy.remove("a")
    sadHappy.funnyPut("three", "five")

    println("<-- NEXT -->")

    println(sadHappy is SadMap<*, *>) // False
    println(sadHappy is MutableMap<*, *>) // True
    println(sadHappy is SadHappyMap<*, *>) // True

    println("<-- NEXT -->")

    // SECOND SAMPLE
    val normalMachine = NormalCoffeeMachine()
    val enhancedMachine = EnhancedCoffeeMachine(normalMachine)

    // non-overridden behaviour
    enhancedMachine.makeSmallCoffee()
    // overriding behaviour
    enhancedMachine.makeLargeCoffee()
    // extended behaviour
    enhancedMachine.makeCoffeeWithMilk()
}

class HappyMap<K, V> : HashMap<K, V>() {
    override fun put(key: K, value: V): V? {
        return super.put(key, value).apply {
            this?.let { // If it is overridden
                println("Yay! $key")
            }
        }
    }
}

// Decorator
class SadHappyMap<K, V>(
    private val map: MutableMap<K, V> =
        mutableMapOf()
) :
    MutableMap<K, V> by map {

    // Overriding behaviour
    override fun put(key: K, value: V): V? {
        return map.put(key, value).apply {
            this?.let { println("Yay! $key") }
        }
    }

    // extended behaviour
    fun funnyPut(key: K, value: V): V? {
        return map.put(key, value).apply {
            println("Fun Yay! $key")
        }
    }
}

class SadMap<K, V> : HashMap<K, V>() {
    override fun remove(key: K): V? {
        println("Okay...")
        return super.remove(key)
    }
}

// SECOND SAMPLE

interface CoffeeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine : CoffeeMachine {
    override fun makeSmallCoffee() = println("Normal: Making small coffee")

    override fun makeLargeCoffee() = println("Normal: Making large coffee")
}

//Decorator:
class EnhancedCoffeeMachine(private val coffeeMachine: CoffeeMachine) : CoffeeMachine by coffeeMachine {

    // overriding behaviour
    override fun makeLargeCoffee() {
        println("Enhanced: Making large coffee")
        coffeeMachine.makeLargeCoffee()
    }

    // extended behaviour
    fun makeCoffeeWithMilk() {
        println("Enhanced: Making coffee with milk")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced: Adding milk")
    }
}

/**
 * interface by constructor
 * Do what overridden and extended
 * in classes by level
 * SadHappyMap -> SapMap
 */