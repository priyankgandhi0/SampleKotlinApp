package com.example.sampleapp.utils

import android.view.View

fun View.onThrottledClick(action: (v: View) -> Unit) {
    setOnClickListener { v ->
        isClickable = false
        action(v)
        postDelayed({ isClickable = true }, 700)
    }
}

