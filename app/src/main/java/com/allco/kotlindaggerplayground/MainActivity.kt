package com.allco.kotlindaggerplayground

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.allco.kotlindaggerplayground.databinding.ActivityMainBinding
import com.allco.kotlindaggerplayground.ioc.AppComponentHolder
import com.allco.kotlindaggerplayground.services.LoginService
import com.allco.kotlindaggerplayground.userdependents.UserDependentActivity
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loginService: LoginService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppComponentHolder.getInstance().inject(this)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btLogin.setOnClickListener { _: View ->
            loginService.login()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { binding.loginInProgress = true }
                    .doOnUnsubscribe { binding.loginInProgress = false }
                    .subscribe { userInfo ->
                        startActivity(UserDependentActivity.createIntent(this, userInfo))
                    }
        }
    }
}


