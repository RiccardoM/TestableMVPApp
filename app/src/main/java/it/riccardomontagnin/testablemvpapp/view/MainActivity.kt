package it.riccardomontagnin.testablemvpapp.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import dagger.android.AndroidInjection
import it.riccardomontagnin.testablemvpapp.R
import it.riccardomontagnin.testablemvpapp.presenter.MainPresenter
import it.riccardomontagnin.testablemvpapp.presenter.MainView
import kotlinx.android.synthetic.main.activity_main.*
import net.grandcentrix.thirtyinch.TiActivity
import javax.inject.Inject

class MainActivity : TiActivity<MainPresenter, MainView>(), MainView {

    @Inject lateinit var presenter: MainPresenter
    override fun providePresenter(): MainPresenter = presenter

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                presenter.homeClicked()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                presenter.dashboardClicked()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                presenter.notificationsClicked()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun showMessage(receivedMessage: MainView.Message) {
        message.text = when(receivedMessage) {
            MainView.Message.HELLO_WORLD -> "Hello world"
            MainView.Message.THIS_IS_A_TESTABLE_APP -> "This is a testable application"
            MainView.Message.HAPPY_TESTING -> "Happy testing!"
        }
    }

}
