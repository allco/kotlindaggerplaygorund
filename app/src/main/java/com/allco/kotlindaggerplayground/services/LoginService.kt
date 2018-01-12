package com.allco.kotlindaggerplayground.services

import rx.Single

interface LoginService {
    fun login(): Single<UserInfo>
}