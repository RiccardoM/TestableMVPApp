package it.riccardomontagnin.testablemvpapp.utils

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import io.mockk.every
import io.mockk.mockk
import net.grandcentrix.thirtyinch.TiConfiguration
import net.grandcentrix.thirtyinch.TiPresenter

/**
 * Creates a mock of a presenter of type [P] setting it up so that it can be used later.
 * @param P: Type of the presenter that should be returned.
 */
inline fun <reified P : TiPresenter<*>> mockPresenter(block: P.() -> Unit = {}): P {
    return mockk(relaxed = true, relaxUnitFun = true, block = block).apply {
        every { state } returns TiPresenter.State.INITIALIZED
        every { config } returns TiConfiguration.DEFAULT
    }
}

fun <A: Activity> getActivityRule(type: Class<A>, injector: A.() -> Unit): ActivityTestRule<A> {
    return object : ActivityTestRule<A>(type, true, true) {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication

        override fun beforeActivityLaunched() {
            app.setTestActivityInjector(type, injector)
        }

        override fun afterActivityFinished() {
            app.resetTestActivityInjector()
        }
    }
}
