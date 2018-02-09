package concrete.workshop.kotlinrobots

class MyChecker : Checker {

    override fun sum(first: Int, second: Int): Int = first + second
    override fun isInteger(value: String): Boolean = value.toIntOrNull() != null

}