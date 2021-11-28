package money

class Dollar(amount: Int): Money(amount) {

    fun times(multiplier: Int) = Dollar(this.amount * multiplier)

}

class Franc(amount: Int): Money(amount) {

    fun times(multiplier: Int) = Franc(this.amount * multiplier)

}

open class Money(protected val amount: Int) {

    override fun equals(other: Any?) = (other as? Money)?.amount == this.amount

}