package it.riccardomontagnin.testablemvpapp.presenter

import net.grandcentrix.thirtyinch.TiView

/**
 * @author Riccardo Montagnin
 * @since 13/11/2018
 */
interface MainView: TiView {

    fun showMessage(receivedMessage: Message)

    enum class Message {
        HELLO_WORLD,
        THIS_IS_A_TESTABLE_APP,
        HAPPY_TESTING
    }

}