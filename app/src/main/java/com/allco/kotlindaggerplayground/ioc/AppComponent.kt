package com.allco.kotlindaggerplayground.ioc

import android.app.Application
import com.allco.kotlindaggerplayground.MainActivity
import com.allco.kotlindaggerplayground.userdependents.ioc.UserComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun userComponentBuilder(): UserComponent.Builder

    fun inject(mainActivity: MainActivity)
}