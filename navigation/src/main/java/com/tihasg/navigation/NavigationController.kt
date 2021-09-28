package com.tihasg.navigation

interface NavigationController {

    companion object {
        var instance : NavigationController? = null
    }
    fun showError(): ErrorNavigationController
}