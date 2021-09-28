package com.tihasg.exemplo.ui

import android.app.Activity
import com.tihasg.navigation.ErrorNavigationController
import com.tihasg.pop_up.OnDialogClickListener
import com.tihasg.pop_up.ViaPopUp

class ErrorNavigationControllerImpl : ErrorNavigationController {
    override fun goToShowError(activity: Activity, message: String, gravity: Int) {
        ViaPopUp.Builder(activity)
            .setGravity(gravity)
            .setMessage(message)
            .setOnClickListener(object : OnDialogClickListener {
                override fun onClick(popUp: ViaPopUp.Builder) {
                    popUp.dismiss()
                }
            })
            .show()
    }

    override fun goToHideError() {
        if (ViaPopUp.alertDialog?.isShowing == true){
            ViaPopUp.alertDialog?.dismiss()
        }
    }
}