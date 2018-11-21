package it.riccardomontagnin.testablemvpapp

import com.agoda.kakao.KButton
import com.agoda.kakao.Screen
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import it.riccardomontagnin.testablemvpapp.presenter.MainPresenter
import it.riccardomontagnin.testablemvpapp.utils.getActivityRule
import it.riccardomontagnin.testablemvpapp.utils.mockPresenter
import it.riccardomontagnin.testablemvpapp.view.MainActivity
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleInstrumentedTest {

    private val presenterMock = mockPresenter<MainPresenter> {
        every { homeClicked() } just runs
        every { dashboardClicked() } just runs
        every { notificationsClicked() } just runs
    }

    @get:Rule val testRule = getActivityRule(MainActivity::class.java) {
        presenter = presenterMock
    }

    @Test fun testClicks() {
        val screen = MainScreen()
        screen {
            navigationHome.isDisplayed()
            navigationDashboard.isDisplayed()
            navigationNotifications.isDisplayed()

            navigationHome.click()
            verify { presenterMock.homeClicked() }

            navigationDashboard.click()
            verify { presenterMock.dashboardClicked() }

            navigationNotifications.click()
            verify { presenterMock.notificationsClicked() }
        }
    }

}

class MainScreen: Screen<MainScreen>() {
    val navigationHome = KButton { withId(R.id.navigation_home) }
    val navigationDashboard = KButton { withId(R.id.navigation_dashboard) }
    val navigationNotifications = KButton { withId(R.id.navigation_notifications) }
}
