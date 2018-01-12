package com.allco.kotlindaggerplayground.services

import javax.inject.Inject

// this can be injected only by UserComponent since it depends from UserInfo
class UserDependentService @Inject constructor(val userInfo: UserInfo)