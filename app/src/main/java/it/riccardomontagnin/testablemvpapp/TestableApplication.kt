package it.riccardomontagnin.testablemvpapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import it.riccardomontagnin.testablemvpapp.injector.DaggerTestableApplicationComponent
import javax.inject.Inject

open class TestableApplication: Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        DaggerTestableApplicationComponent.create().inject(this)
        super.onCreate()
    }

}