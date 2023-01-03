package design_pattern.behavioral

fun main() {
    val originator = Originator("initial state")
    val careTaker = CareTaker()
    careTaker.saveState(originator.createMemento())

    originator.state = "State #1"
    originator.state = "State #2"
    careTaker.saveState(originator.createMemento())

    originator.state = "State #3"
    println("Current State: " + originator.state)

    originator.restore(careTaker.restore(1))
    println("Second saved state: " + originator.state)

    originator.restore(careTaker.restore(0))
    println("First saved state: " + originator.state)
}

data class Memento(val state: String)

class Originator(var state: String) {

    fun createMemento(): Memento {
        return Memento(state)
    }

    fun restore(memento: Memento) {
        state = memento.state
    }
}

class CareTaker {
    private val mementoList = ArrayList<Memento>()

    fun saveState(memento: Memento) {
        mementoList.add(memento)
    }

    fun restore(index: Int): Memento {
        return mementoList[index]
    }
}

/**
 * Undo vie rollback
 */