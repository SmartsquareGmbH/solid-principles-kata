package de.smartsquare.gateway

import org.amshove.kluent.invoking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldThrow
import org.junit.jupiter.api.Test

class PaypalGatewayTests {

    @Test
    internal fun `send money`() {
        val gateway = PaypalGateway()

        gateway.send(100.0, "invalid@smartquare.de")

        gateway.balance shouldBeEqualTo 0.0
    }

    @Test
    internal fun `send money from a insufficient covered account`() {
        val gateway = PaypalGateway()

        invoking { gateway.send(101.0, "dierkes@smartquare.de") } shouldThrow IllegalArgumentException::class
    }

    @Test
    internal fun `request money`() {
        val gateway = PaypalGateway()

        gateway.request(20.0, "dierkes@smartsquare.de")

        gateway.balance shouldBeEqualTo 120.0
    }
}
