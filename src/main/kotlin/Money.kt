package money

class Dollar(private var amount: Int) {

    fun times(multiplier: Int) = Dollar(this.amount * multiplier)

    override fun equals(other: Any?) = (other as? Dollar)?.amount == this.amount

}