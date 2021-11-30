package money

class Money(val amount: Int, val currency: String): Expression {

    override fun toString() = "amount: $amount, currency: $currency"

    override fun equals(other: Any?) = (other as? Money)?.amount == this.amount && this.currency == other.currency

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")
        fun franc(amount: Int) = Money(amount, "CHF")
    }

    override fun plus(addend: Expression): Expression = Sum(this, addend)

    override fun times(multiplier: Int): Money = Money(this.amount * multiplier, this.currency)

    override fun reduce(bank: Bank, to: String): Money {
        val rate = if (this.currency != to) bank.rate(this.currency, to) else 1
        return Money(this.amount / rate, to)
    }
}