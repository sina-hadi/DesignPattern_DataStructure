package design_pattern.behavioral

fun main() {

    // DSL
    val sql = select("name, age") {
        from("users") {
            where("age > 20")
        }
    }
    println(sql)
}

fun select(column: String, from: SelectClause.() -> Unit): SelectClause {
    return SelectClause(column).apply(from)
}

class SelectClause(private val columnName: String) {

    lateinit var fromClause: FromClause

    fun from(tableName: String, where: FromClause.() -> Unit) {
        fromClause = FromClause(tableName).apply(where)
    }

    override fun toString() = "SELECT $columnName $fromClause"
}

class FromClause(private val tableName: String) {

    lateinit var condition: WhereClause

    fun where(condition: String) {
        this.condition = WhereClause(condition)
    }

    override fun toString() = "FROM $tableName $condition"
}

class WhereClause(private val condition: String) {
    override fun toString() = "WHERE $condition"
}

/**
 * The pattern defines the grammar of a particular language
 * in an object-oriented way
 * which can be evaluated by the interpreter itself.
 */