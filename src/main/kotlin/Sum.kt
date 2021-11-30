package money

class Sum(private val augend: Expression, private val addend: Expression): Expression {

    override fun reduce(bank: Bank, to: String): Money =
        Money(augend.reduce(bank, to).amount + addend.reduce(bank, to).amount, to)

    override fun plus(addend: Expression): Expression = Sum(this, addend)

    override fun times(multiplier: Int): Expression = Sum(this.augend.times(multiplier), this.addend.times(multiplier))
}