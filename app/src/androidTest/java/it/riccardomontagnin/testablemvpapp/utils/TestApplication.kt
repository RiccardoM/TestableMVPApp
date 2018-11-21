package it.riccardomontagnin.testablemvpapp.utils

import android.app.Activity
import android.support.annotation.VisibleForTesting
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import it.riccardomontagnin.testablemvpapp.TestableApplication
import javax.inject.Provider


class TestApplication: TestableApplication() {

    private var customInjector: AndroidInjector<Activity>? = null
    override fun activityInjector(): AndroidInjector<Activity> = customInjector ?: super.activityInjector()

    @VisibleForTesting
    fun resetTestActivityInjector() {
        customInjector = null
    }

    @VisibleForTesting
    fun setTestActivityInjector(clazz: Class<out Activity>, injector: AndroidInjector<in Activity>) {
        val factory = AndroidInjector.Factory<Activity> { AndroidInjector { instance -> injector.inject(instance) } }
        val provider = Provider<AndroidInjector.Factory<out Activity>> { factory }
        val injectorFactories = mapOf(clazz to provider)

        customInjector = DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(injectorFactories, mapOf())
    }

    @VisibleForTesting
    inline fun <A : Activity> setTestActivityInjector(type: Class<A>, crossinline injector: (A) -> Unit) {
        setTestActivityInjector(type, AndroidInjector { if (type.isInstance(it)) injector(it as A) })
    }

}