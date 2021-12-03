package com.tihasg.exemplo.ui

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tihasg.exemplo.R
import com.tihasg.pop_up.OnDialogClickListener
import com.tihasg.pop_up.ViaPopUp
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModel()
    private var textView: TextView? = null
    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textId)
        image = findViewById(R.id.imageView)

        viewModel.getCount()
        viewModel.getInfo()

        bindStates()
    }


    private fun bindStates() {
        viewModel.count.observeForever {
            ViaPopUp.Builder(this)
                .setGravity(Gravity.CENTER)
                .setMessage(it.toString())
                .setOnClickListener(object : OnDialogClickListener {
                    override fun onClick(popUp: ViaPopUp.Builder) {
                        popUp.dismiss()
                    }
                })
                .show()
        }

        viewModel.info.observeForever {
            textView?.text = "version:${it.version}"
        }
    }

}