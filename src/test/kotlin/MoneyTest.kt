package money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import kotlin.test.assertEquals

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

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum = five.plus(five)
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        Assertions.assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun testPlusReturnsSum() {
        val five = Money.dollar(5)
        val sum: Sum = five.plus(Money.dollar(5))
        Assertions.assertEquals(five, sum.augend)
        Assertions.assertEquals(five, sum.addend)
    }

    @Test
    fun testReduceSum() {
        val sum = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        Assertions.assertEquals(Money.dollar(7), reduced)
    }

    @Test
    fun testReduceMoney() {
        val bank = Bank()
        val result: Money = bank.reduce(Money.dollar(1), "USD")
        Assertions.assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(Money.franc(2), "USD")
        Assertions.assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }
}