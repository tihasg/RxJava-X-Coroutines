package com.tihasg.rxjava.ui

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tihasg.pop_up.OnDialogClickListener
import com.tihasg.pop_up.ViaPopUp
import com.tihasg.rxjava.R

import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModel()

    //referenciando componente do android
    private var textView: TextView? = null
    private var image: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //vinculando com layout
        textView = findViewById(R.id.textId)
        image = findViewById(R.id.imageView)
        viewModel.loadCount()
        bindStates()
    }


    private fun bindStates() {
        //escutando livedate que tá na view model
        viewModel.count.observeForever {
            //fazendo uma ação com o valor que esta retornando, a ação é setar o texto
            textView?.text = it.toString()

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
    }

}