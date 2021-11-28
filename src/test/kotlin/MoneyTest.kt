package money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class MoneyTest {

    @Test
    fun testMultiplication() {
        val five = Money.dollar(5)
        Assertions.assertEquals(Money.dollar(10), five.times(2))
        Assertions.assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testEquality() {
        Assertions.assertTrue(Money.dollar(5) == (Money.dollar(5)))
        Assertions.assertFalse(Money.dollar(5) == (Money.dollar(6)))
    }

    @Test
    fun testCurrency() {
        Assertions.assertEquals("USD", Money.dollar(1).currency)
        Assertions.assertEquals("CHF", Money.franc(1).currency)
    }
}