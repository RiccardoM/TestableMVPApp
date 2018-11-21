package it.riccardomontagnin.testablemvpapp.utils

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

/**
 * @author Riccardo Montagnin
 * @since 13/11/2018
 */
class TestRunner : AndroidJUnitRunner() {

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(classLoader: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(classLoader, TestApplication::class.java.name, context)
    }

}