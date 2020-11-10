package de.smartsquare.gateway

interface Gateway {

    val balance: Double

    val hasPositiveBalance get() = balance >= 0

    fun send(amount: Double, email: String)

    fun request(amount: Double, email: String)
}
