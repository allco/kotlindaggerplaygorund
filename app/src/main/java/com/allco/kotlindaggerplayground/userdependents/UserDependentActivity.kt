package com.allco.kotlindaggerplayground.userdependents

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.allco.kotlindaggerplayground.R
import com.allco.kotlindaggerplayground.createViewFactoryFactory
import com.allco.kotlindaggerplayground.databinding.ActivityUserDependentBinding
import com.allco.kotlindaggerplayground.ioc.AppComponentHolder
import com.allco.kotlindaggerplayground.services.UserInfo

class UserDependentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUserDependentBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_dependent)
        binding.userModel = getViewModel()
    }

    private fun getViewModel(): UserDependentViewModel {
        return ViewModelProviders.of(this,
                // this is an implementation of ViewModelProvider.Factory
                createViewFactoryFactory {
                    AppComponentHolder.getInstance()
                            .userComponentBuilder()
                            .setUserInfo(extractUserInfo(intent))
                            .build()
                            .createUserDependentViewModel()
                }).get(UserDependentViewModel::class.java)
    }

    companion object {
        private val USER_INFO = "USER_INFO"
        fun createIntent(context: Context, userInfo: UserInfo) =
                Intent(context, UserDependentActivity::class.java).also {
                    it.putExtra(USER_INFO, userInfo)
                }

        private fun extractUserInfo(intent: Intent): UserInfo = intent.getParcelableExtra(USER_INFO)
    }
}
