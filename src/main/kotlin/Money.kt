package money

class Dollar(amount: Int): Money(amount) {

    override fun times(multiplier: Int) = Dollar(this.amount * multiplier)

}

class Franc(amount: Int): Money(amount) {

    override fun times(multiplier: Int) = Franc(this.amount * multiplier)

}

abstract class Money(protected val amount: Int) {

    override fun equals(other: Any?) = (other as? Money)?.amount == this.amount && this.javaClass == other.javaClass

    companion object {
        fun dollar(amount: Int) = Dollar(amount)
        fun franc(amount: Int) = Franc(amount)
    }

    abstract fun times(multiplier: Int): Money

}
