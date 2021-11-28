package money

open class Money(protected val amount: Int, open val currency: String) {

    override fun equals(other: Any?) = (other as? Money)?.amount == this.amount && this.currency == other.currency

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")
        fun franc(amount: Int) = Money(amount, "CHF")
    }

    fun times(multiplier: Int) = Money(amount * multiplier, currency)

}
