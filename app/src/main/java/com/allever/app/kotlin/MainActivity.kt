package com.allever.app.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivImageView.load(R.mipmap.ic_launcher)
    }
}