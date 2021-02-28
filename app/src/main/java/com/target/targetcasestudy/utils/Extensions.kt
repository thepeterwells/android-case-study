package com.target.targetcasestudy.utils

import android.view.View

fun View.setVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}