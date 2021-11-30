package money

interface Expression {
    abstract fun reduce(bank: Bank, to: String): Money
    abstract fun plus(addend: Expression): Expression
    abstract fun times(multiplier: Int): Expression
}