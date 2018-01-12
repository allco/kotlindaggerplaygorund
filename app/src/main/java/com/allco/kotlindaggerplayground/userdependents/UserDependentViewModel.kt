package com.allco.kotlindaggerplayground.userdependents

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import com.allco.kotlindaggerplayground.services.UserDependentService
import com.allco.kotlindaggerplayground.services.UserInfo
import com.allco.kotlindaggerplayground.userdependents.ioc.UserComponent
import javax.inject.Inject

class UserDependentViewModel @Inject constructor(
        // let's inject all the dependencies
        application: Application,
        `userInfo`: UserInfo,
        // UserDependentService its being injected here by constructor (there is no @Provides method for it, which is wonderful)
        userDependentService: UserDependentService,

        // also it is even possible to inject the component itself
        // (but mostly it is not needed, since any kind of custom Builders/Providers should be used instead)
        userComponent: UserComponent
)
// it is an android.arch.*.ViewModel
    : AndroidViewModel(application) {

    // an Observable for DataBinding
    val userInfo = ObservableField(`userInfo`)
}