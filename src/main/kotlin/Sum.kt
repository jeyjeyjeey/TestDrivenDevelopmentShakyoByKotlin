package money

class Sum(val augend: Money, val addend: Money): Expression {

    override fun reduce(bank: Bank, to: String): Money = Money(augend.amount + addend.amount, to)

}