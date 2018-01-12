package com.allco.kotlindaggerplayground.services

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(val name: String, val email: String) : Parcelable