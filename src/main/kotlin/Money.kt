package money

class Money(val amount: Int, val currency: String): Expression {

    override fun equals(other: Any?) = (other as? Money)?.amount == this.amount && this.currency == other.currency

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")
        fun franc(amount: Int) = Money(amount, "CHF")
    }

    fun times(multiplier: Int) = Money(amount * multiplier, currency)

    fun plus(addend: Money) = Sum(this, addend)

    override fun reduce(bank: Bank, to: String): Money {
        val rate = if (this.currency != to) bank.rate(this.currency, to) else 1
        return Money(this.amount / rate, to)
    }
}