package money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class MoneyTest {

    @Test
    fun testDollarMultiplication() {
        val five = Dollar(5)
        Assertions.assertEquals(Dollar(10), five.times(2))
        Assertions.assertEquals(Dollar(15), five.times(3))
    }

    @Test
    fun testDollarEquality() {
        Assertions.assertTrue(Dollar(5) == (Dollar(5)))
        Assertions.assertFalse(Dollar(5) == (Dollar(6)))
    }

    @Test
    fun testFrancMultiplication() {
        val five = Franc(5)
        Assertions.assertEquals(Franc(10), five.times(2))
        Assertions.assertEquals(Franc(15), five.times(3))
    }

    @Test
    fun testFrancEquality() {
        Assertions.assertTrue(Franc(5) == (Franc(5)))
        Assertions.assertFalse(Franc(5) == (Franc(6)))
    }
}