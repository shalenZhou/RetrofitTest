package com.example.retrofittest

import android.view.View

typealias ClickAction = () -> Unit

fun View.setClickAction(action: ClickAction?) {
    if (action == null) {
        setOnClickListener(null)
        isClickable = false
    } else {
        setOnClickListener { action() }
    }
}