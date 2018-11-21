package it.riccardomontagnin.testablemvpapp.injector

import dagger.Module
import dagger.android.ContributesAndroidInjector
import it.riccardomontagnin.testablemvpapp.view.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity

}