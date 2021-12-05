package com.tihasg.rxjava.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tihasg.rxjava.R

import org.koin.android.viewmodel.ext.android.viewModel
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModel()
    private var textView: TextView? = null
    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textId)
        image = findViewById(R.id.imageView)

        viewModel.loadCount()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setCount(it)
            }, {
                setError(it.message.toString())
            })


        viewModel.loadInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                textView?.text = "version:${it.version}"
            }, {
                setError(it.message.toString())
            })
    }


    private fun setCount(value: Int) {
       Toast.makeText(this, value.toString(), Toast.LENGTH_LONG).show()
    }

    private fun setError(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }

}