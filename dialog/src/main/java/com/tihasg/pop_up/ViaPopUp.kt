package com.tihasg.pop_up

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.annotation.Keep
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

@Keep
class ViaPopUp {
    class Builder(
        @NonNull private val activity: Activity
    ) {
        private val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity)
        private var message: String = "Message"
        private var isCancelable: Boolean = true
        private var gravity: Int = Gravity.NO_GRAVITY
        private lateinit var layoutView: View

        private var onClickListener: OnDialogClickListener = object : OnDialogClickListener {
            override fun onClick(dialog: Builder) {
                dialog.dismiss()
            }
        }

        @NonNull
        fun setMessage(@NonNull message: String): Builder {
            this.message = message
            return this
        }


        @NonNull
        fun setOnClickListener(onDialogClickListener: OnDialogClickListener): Builder {
            this.onClickListener = onDialogClickListener
            return this
        }

        @NonNull
        fun setGravity(gravity: Int): Builder {
            this.gravity = gravity
            return this
        }

        @NonNull
        fun dismiss(): ViaPopUp {
            if (alertDialog?.isShowing == true) {
                alertDialog?.dismiss()
            }
            return ViaPopUp()
        }

        @NonNull
        fun show(): ViaPopUp {
            layoutView = activity.layoutInflater.inflate(R.layout.pop_up, null)
            val imgClose: AppCompatImageView = layoutView.findViewById(R.id.image_close)
            val textMessage: AppCompatTextView = layoutView.findViewById(R.id.text_message)
            textMessage.text = message

            dialogBuilder.setView(layoutView)
            alertDialog = dialogBuilder.create()
            dismiss()
            alertDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            alertDialog?.window?.setGravity(Gravity.TOP)
            if (alertDialog?.isShowing == false){
                alertDialog?.show()
            }

            alertDialog?.window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
            imgClose.setOnClickListener { onClickListener.onClick(this) }

            alertDialog?.setCancelable(isCancelable)
            if (gravity != Gravity.NO_GRAVITY) {
                alertDialog?.window?.setGravity(gravity)
            }
            return ViaPopUp()
        }
    }

    companion object {
        var alertDialog: AlertDialog? = null

    }
}