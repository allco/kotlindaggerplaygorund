package com.allco.kotlindaggerplayground.userdependents.ioc

import com.allco.kotlindaggerplayground.services.UserInfo
import com.allco.kotlindaggerplayground.userdependents.UserDependentViewModel
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface UserComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun setUserInfo(userInfo: UserInfo): Builder

        fun build(): UserComponent
    }

    fun createUserDependentViewModel(): UserDependentViewModel
}
