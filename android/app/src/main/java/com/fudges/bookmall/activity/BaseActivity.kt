package com.fudges.bookmall.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fudges.bookmall.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
