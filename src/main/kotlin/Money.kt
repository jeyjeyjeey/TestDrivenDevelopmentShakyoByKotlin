package money

class Dollar(amount: Int, currency: String): Money(amount, currency) {

    override fun times(multiplier: Int) = dollar(this.amount * multiplier)

}

class Franc(amount: Int, currency: String): Money(amount, currency) {

    override fun times(multiplier: Int) = franc(this.amount * multiplier)

}

abstract class Money(protected val amount: Int, open val currency: String) {

    override fun equals(other: Any?) = (other as? Money)?.amount == this.amount && this.javaClass == other.javaClass

    companion object {
        fun dollar(amount: Int) = Dollar(amount, "USD")
        fun franc(amount: Int) = Franc(amount, "CHF")
    }

    abstract fun times(multiplier: Int): Money

}
