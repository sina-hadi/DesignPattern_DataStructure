package data_structure.stack

class StackImpl<T> : Stack<T> {

    private var storage = arrayListOf<T>()


    override val count: Int
        get() = storage.size

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun push(element: T) {
        storage.add(element)
    }
}