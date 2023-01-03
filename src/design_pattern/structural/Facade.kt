package design_pattern.structural

fun main() {
    val userRepository = UserRepository()
    val user = User("dbacinski")
    userRepository.save(user)
    val resultUser = userRepository.findFirst()
    println("Found stored user: $resultUser")
}

class ComplexSystemStore(private val filePath: String) {

    init {
        println("Reading data from file: $filePath")
    }

    private val store = HashMap<String, String>()

    fun store(key: String, payload: String) {
        store[key] = payload
    }

    fun read(key: String): String = store[key] ?: ""

    fun commit() = println("Storing cached data: $store to file: $filePath")
}

data class User(val login: String)

// Facade
class UserRepository {
    private val systemPreferences = ComplexSystemStore("/data/default.prefs")

    fun save(user: User) {
        systemPreferences.store("USER_KEY", user.login)
        systemPreferences.commit()
    }

    fun findFirst(): User = User(systemPreferences.read("USER_KEY"))
}