package com.allco.kotlindaggerplayground.ioc

class AppComponentHolder {

    companion object {

        @Volatile private var INSTANCE: AppComponent? = null
        var CREATOR: (() -> AppComponent)? = null
            set(value) {
                // allow to setup the CREATOR only once
                // it could be called from any test then the original version (production version) will be ignored
                if (field == null) {
                    field = value
                }
            }

        fun getInstance(): AppComponent =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: CREATOR!!().also { INSTANCE = it }
                }
    }
}