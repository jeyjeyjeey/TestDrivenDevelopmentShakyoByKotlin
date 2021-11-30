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
    fun testReduceSum() {
        val sum = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        Assertions.assertEquals(Money.dollar(7), reduced)
    }

    @Test
    fun testReduceMoney() {
        val bank = Bank()
        val result: Expression = bank.reduce(Money.dollar(1), "USD")
        Assertions.assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Expression = bank.reduce(Money.franc(2), "USD")
        Assertions.assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

    @Test
    fun testMixedCurrencyAddition() {
        val fiveDollar: Expression = Money.dollar(5)
        val tenFranc: Expression = Money.franc(10)
        val sum: Expression = fiveDollar.plus(tenFranc)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        Assertions.assertEquals(Money.dollar(10), bank.reduce(sum, "USD"))
    }

    @Test
    fun testSumPlusMoney() {
        val fiveBucks = Money.dollar(5)
        val sum = Sum(Money.dollar(5), Money.franc(10))
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = sum.plus(fiveBucks).reduce(bank, "USD")
        Assertions.assertEquals(15, result.amount)
    }

    @Test
    fun testSumTimes() {
        val fiveBucks = Money.dollar(5)
        val tenFranc = Money.franc(10)
        val sum = Sum(fiveBucks, tenFranc)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = sum.times(2).reduce(bank, "USD")
        Assertions.assertEquals(Money.dollar(20), result)
    }

}