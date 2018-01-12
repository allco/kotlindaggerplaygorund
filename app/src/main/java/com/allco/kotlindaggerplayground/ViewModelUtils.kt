package com.allco.kotlindaggerplayground

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

fun <T : ViewModel> createViewFactoryFactory(factory: () -> T): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T = factory() as T
        }
