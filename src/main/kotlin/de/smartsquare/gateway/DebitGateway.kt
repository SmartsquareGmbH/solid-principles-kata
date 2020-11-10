package de.smartsquare.gateway

class DebitGateway : Gateway {

    override var balance: Double = 100.0

    override fun send(amount: Double, email: String) {
        require(this.balance >= amount) { "Account is not sufficiently funded" }
        require(amount >= 0) { "Amount must be positive" }

        // this would be a bunch of http requests in a real world
        balance -= amount
    }

    @Suppress("EmptyFunctionBlock")
    override fun request(amount: Double, email: String) {}
}
