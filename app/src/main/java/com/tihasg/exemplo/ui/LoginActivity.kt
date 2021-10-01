package com.tihasg.exemplo.ui

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tihasg.exemplo.R
import com.tihasg.pop_up.OnDialogClickListener
import com.tihasg.pop_up.ViaPopUp
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModel()

    //referenciando componente do android
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //vinculando com layout
        textView = findViewById(R.id.textId)
        viewModel.getCount()
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