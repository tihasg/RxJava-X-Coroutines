package com.tihasg.exemplo.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tihasg.exemplo.R
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

        viewModel.count.observeForever {
            setCount(it)
        }

        viewModel.info.observeForever {
            textView?.text = "version:${it.version}"
        }

        viewModel.error.observeForever {
            setError(it)
        }
    }

    private fun setCount(value: Int) {
        Toast.makeText(this, value.toString(), Toast.LENGTH_LONG).show()
    }

    private fun setError(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }

}