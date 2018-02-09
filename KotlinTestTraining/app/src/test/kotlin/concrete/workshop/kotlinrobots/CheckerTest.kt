package concrete.workshop.kotlinrobots

import org.junit.Assert.*
import org.junit.Test

class CheckerTest {

    val checker = CheckerProvider.getChecker()

    @Test
    fun whenAddTwoToTwo_shouldReturnFour() {
        assertEquals(4, checker.sum(2, 2))
    }

    @Test
    fun whenAddTwoToFour_shouldReturnSix() {
        assertEquals(6, checker.sum(2, 4))
    }

    @Test
    fun whenPassInvalidNumber_shouldReturnFalse() {
        assertFalse(checker.isInteger("abc"))
    }

    @Test
    fun whenPassIntegerNumber_shouldReturnTrue() {
        assertTrue(checker.isInteger("123"))
    }

    @Test
    fun whenPassDoubleNumber_shouldReturnTrue() {
        assertFalse(checker.isInteger("12,3"))
    }

}
