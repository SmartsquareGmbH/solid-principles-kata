package de.smartsquare

import org.amshove.kluent.shouldBeTrue
import org.junit.jupiter.api.Test

class SoftwareTests {

    @Test
    fun `software is written in a way that the independent components are reusable`() {
        Software().hasReusableCode.shouldBeTrue()
    }
}
