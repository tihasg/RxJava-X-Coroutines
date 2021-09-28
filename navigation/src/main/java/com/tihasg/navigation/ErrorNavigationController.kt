package com.tihasg.navigation

import android.app.Activity
import android.content.Context
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface ErrorNavigationController {
    fun goToShowError(activity: Activity, message: String, gravity: Int)
    fun goToHideError()
}
