package money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class MoneyTest {

    @Test
    fun testDollarMultiplication() {
        val five = Money.dollar(5)
        Assertions.assertEquals(Money.dollar(10), five.times(2))
        Assertions.assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testDollarEquality() {
        Assertions.assertTrue(Money.dollar(5) == (Money.dollar(5)))
        Assertions.assertFalse(Money.dollar(5) == (Money.dollar(6)))
    }

    @Test
    fun testFrancMultiplication() {
        val five = Money.franc(5)
        Assertions.assertEquals(Money.franc(10), five.times(2))
        Assertions.assertEquals(Money.franc(15), five.times(3))
    }

    @Test
    fun testFrancEquality() {
        Assertions.assertTrue(Money.franc(5) == (Money.franc(5)))
        Assertions.assertFalse(Money.franc(5) == (Money.franc(6)))
    }

    @Test
    fun testEqualityFrancAndDollar() {
        Assertions.assertFalse(Money.dollar(5).equals(Money.franc(5)))
    }

    @Test
    fun testCurrency() {
        Assertions.assertEquals("USD", Money.dollar(1).currency)
        Assertions.assertEquals("CHF", Money.franc(1).currency)
    }
}