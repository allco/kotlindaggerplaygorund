package com.allco.kotlindaggerplayground.ioc

import android.support.annotation.NonNull
import com.allco.kotlindaggerplayground.services.LoginService
import com.allco.kotlindaggerplayground.services.UserInfo
import dagger.Module
import dagger.Provides
import rx.Single
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    @NonNull
    fun provideLoginService(): LoginService {
        // lets return trivial anonymous class which implements LoginService
        // in reality it should be implemented by Retrofit
        return object : LoginService {
            override fun login(): Single<UserInfo> {
                // network request should happen here
                return Single
                        .just(UserInfo("vincent", "vincent@email.com"))
                        // emulate the network latency
                        .delay(1000, TimeUnit.MILLISECONDS)
            }
        }
    }
}