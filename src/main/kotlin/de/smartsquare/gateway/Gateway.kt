package de.smartsquare.gateway

interface Gateway {

    val balance: Double

    fun send(amount: Double, email: String)

    fun request(amount: Double, email: String)

    fun ping(): Long
}
