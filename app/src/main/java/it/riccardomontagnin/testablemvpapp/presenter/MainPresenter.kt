package it.riccardomontagnin.testablemvpapp.presenter

import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.kotlin.deliverToView
import javax.inject.Inject

/**
 * @author Riccardo Montagnin
 * @since 13/11/2018
 */
class MainPresenter @Inject constructor(): TiPresenter<MainView>() {

    fun homeClicked() {
        deliverToView { showMessage(MainView.Message.HELLO_WORLD) }
    }

    fun dashboardClicked() {
        deliverToView { showMessage(MainView.Message.THIS_IS_A_TESTABLE_APP) }
    }

    fun notificationsClicked() {
        deliverToView { showMessage(MainView.Message.HAPPY_TESTING) }
    }

}