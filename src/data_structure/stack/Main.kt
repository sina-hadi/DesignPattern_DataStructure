package data_structure.stack

fun main() {
    println("false -> ((((())))))".isValidParentheses())
    println("false -> ((((())))".isValidParentheses())
    println("false -> )((((())))".isValidParentheses())
    println("true -> (())()((()))(()())".isValidParentheses())
}

fun String.isValidParentheses(): Boolean {

    val stack = StackImpl<Char>()

    for (char in this) {
        when (char) {
            '(' -> {
                stack.push(char)
            }
            ')' -> {
                if (stack.isEmpty) {
                    return false
                } else {
                    stack.pop()
                }
            }
        }
    }

    return stack.isEmpty
}