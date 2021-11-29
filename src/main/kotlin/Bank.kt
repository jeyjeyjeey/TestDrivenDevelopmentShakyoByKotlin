package money

import java.util.*

class Bank {

    private val rates: MutableMap<Pair<String, String>, Int> = HashMap()

    fun reduce(source: Expression, to: String): Expression = source.reduce(this, to)

    fun addRate(from: String, to: String, rate: Int) = rates.put(Pair(from, to), rate)

    fun rate(from: String, to: String) =
        if (from == to) 1
        else rates[Pair(from, to)] ?: throw IllegalArgumentException("Unregistered rate $from to $to")

}