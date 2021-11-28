package money

interface Expression {
    abstract fun reduce(to: String): Money
}