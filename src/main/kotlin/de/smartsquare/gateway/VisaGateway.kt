package de.smartsquare.gateway

import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.schedule

class VisaGateway : Gateway {

    private val syncTimer = Timer()

    private lateinit var task: TimerTask

    override var balance: Double = 100.0

    private var reserved: Double = 0.0

    private val available get() = balance - reserved

    override fun send(amount: Double, email: String) {
        require(this.available >= amount) { "Account is not sufficiently funded" }
        require(amount >= 0) { "Amount must be positive" }

        // this would be a bunch of http requests in a real world
        reserved += amount

        if (!this::task.isInitialized || System.currentTimeMillis() - task.scheduledExecutionTime() >= 0) {
            this.task = syncTimer.schedule((10_000L..60_000L).random()) {
                balance -= reserved

                reserved = 0.0
            }
        }
    }

    @Suppress("EmptyFunctionBlock")
    override fun request(amount: Double, email: String) {
    }

    override fun ping(): Long {
        return 35L
    }
}
