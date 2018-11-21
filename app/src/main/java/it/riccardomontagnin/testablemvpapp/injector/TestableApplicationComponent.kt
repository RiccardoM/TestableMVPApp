package it.riccardomontagnin.testablemvpapp.injector

import dagger.Component
import dagger.android.AndroidInjectionModule
import it.riccardomontagnin.testablemvpapp.TestableApplication

@Component(modules = [
    AndroidInjectionModule::class,

    ActivityModule::class
])
interface TestableApplicationComponent {
    fun inject(app: TestableApplication)
}