package com.allco.kotlindaggerplayground

import android.app.Application
import com.allco.kotlindaggerplayground.ioc.AppComponentHolder
import com.allco.kotlindaggerplayground.ioc.DaggerAppComponent

class PlaygroundApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponentHolder.CREATOR = { DaggerAppComponent.builder().setApplication(this).build() }
    }
}