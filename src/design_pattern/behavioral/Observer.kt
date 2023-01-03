package design_pattern.behavioral

import kotlin.properties.Delegates

fun main() {

    // Observer by hand
    val myObservable = BaeldungNewsletter()
    val myObservable2 = BaeldungNewsletter()

    val myObserver = BaeldungReader(myObservable)
    val myObserver2 = BaeldungReader(myObservable)
    val myObserver3 = BaeldungReader(myObservable2)

    myObservable.observers.add(myObserver)
    myObservable.observers.add(myObserver2)
    myObservable2.observers.add(myObserver3)

    myObservable.newestArticleUrl = "Hello there !!"
    myObservable2.newestArticleUrl = "Hey It's me !!"

    // Observer by Delegates and Observer
    val newsletter = BaeldungNewsletter2()
    newsletter.newestArticleObservers.add { newestArticleUrl ->
        println("New Baeldung article 2 : $newestArticleUrl")
    }
    newsletter.newestArticleUrl = "FUCK YOU ??"
    newsletter.newestArticleUrl = "FUCK YOU TOO ??"

}

interface IObserver {
    fun update()
}

interface IObservable {
    val observers: ArrayList<IObserver>

    fun add(observer: IObserver) {
        observers.add(observer)
    }

    fun remove(observer: IObserver) {
        observers.remove(observer)
    }

    fun sendUpdateEvent() {
        observers.forEach { it.update() }
    }
}

class BaeldungNewsletter : IObservable {
    override val observers: ArrayList<IObserver> = ArrayList()
    var newestArticleUrl = ""
        set(value) {
            field = value
            sendUpdateEvent()
        }
}

class BaeldungReader(private var newsletter: BaeldungNewsletter) : IObserver {
    override fun update() {
        println("New Baeldung article: ${newsletter.newestArticleUrl}")
    }
}

class BaeldungNewsletter2 {
    val newestArticleObservers = mutableListOf<(String) -> Unit>()

    var newestArticleUrl: String by Delegates.observable("") { _, _, newValue ->
        newestArticleObservers.forEach { it(newValue) }
    }
}