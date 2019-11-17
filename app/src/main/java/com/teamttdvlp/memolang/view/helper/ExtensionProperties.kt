package com.teamttdvlp.memolang.view.helper

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.EditText

fun quickLog (message : Any) {
    Log.e("QuickLog: ", message.toString())
}

fun Animation.addAnimationLister (onStart : ((Animation?) -> Unit)? = null, onEnd : ((Animation?) -> Unit)? = null, onRepeat: ((Animation?) -> Unit)? = null) {
    setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(p0: Animation?) {
            onRepeat?.invoke(p0)
        }

        override fun onAnimationEnd(p0: Animation?) {
            onEnd?.invoke(p0)
        }

        override fun onAnimationStart(p0: Animation?) {
            onStart?.invoke(p0)
        }
    })
}

fun EditText.addTextChangeListener (
    afterTextChanged : ((Editable?) -> Unit)? = null,
    beforeTextChanged : ((CharSequence?, Int, Int, Int) -> Unit)? = null,
    onTextChanged : ((CharSequence?, Int, Int, Int) -> Unit)? = null ) {

    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            afterTextChanged?.invoke(p0)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            beforeTextChanged?.invoke(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            onTextChanged?.invoke(p0, p1, p2, p3)
        }
    })
}


fun View.disappear() {
    visibility = View.GONE
}

fun View.appear() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.isVisible () : Boolean{
    return visibility == View.VISIBLE
}

fun View.isGone () : Boolean{
    return visibility == View.GONE
}

fun View.isInvisible() : Boolean{
    return visibility == View.INVISIBLE
}