package com.teamttdvlp.memolang.view.customview

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.addListener
import androidx.core.view.children
import com.teamttdvlp.memolang.R
import com.teamttdvlp.memolang.view.helper.appear
import com.teamttdvlp.memolang.view.helper.disappear
import com.teamttdvlp.memolang.view.helper.quickLog

class MyCustomDialog (context : Context, attrSet : AttributeSet) : ConstraintLayout(context, attrSet) {

    private val showBackgroundAnmtr : Animator

    private val hideBackgroundAnmtr : Animator

    private val hideAnmtrList = ArrayList<Animator>()

    private val showAnmtrList = ArrayList<Animator>()

    private val view : ConstraintLayout

    private var isShow = true

    private var onHide : (() -> Unit)? = null

    private var onShow  : (() -> Unit)? = null

    init {
        view = inflate(context, R.layout.custom_dialert,this) as ConstraintLayout
        showBackgroundAnmtr = AnimatorInflater.loadAnimator(context, R.animator.appear_100_percents)
        hideBackgroundAnmtr = AnimatorInflater.loadAnimator(context, R.animator.disappear_100_percents)
        showBackgroundAnmtr.setTarget(view)
        hideBackgroundAnmtr.setTarget(view)
        visibility = View.GONE

        showBackgroundAnmtr.addListener(
        onStart = {
            appear()
        },
        onEnd = {
            showAnmtrList.forEach {
                it.start()
                onShow?.invoke()
            }
        })

        hideBackgroundAnmtr.addListener (onEnd = {
            disappear()
            onHide?.invoke()
        })

        view.setOnClickListener {
            hide()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        children.forEachIndexed { index, view ->
            val isNotBlackBackground = index != 0
            if (isNotBlackBackground) {

                val hideAnimator = AnimatorInflater.loadAnimator(context, R.animator.disappear_100_percents)
                val showAnimator = AnimatorInflater.loadAnimator(context, R.animator.appear_100_percents)

                hideAnimator.setTarget(view)
                hideAnimator.addListener (onEnd = {
                    view.disappear()
                    if (index == children.count() - 1) {
                        hideBackgroundAnmtr.start()
                    }})
                hideAnmtrList.add(hideAnimator)

                showAnimator.setTarget(view)
                showAnimator.addListener (onStart = {
                    view.appear()
                })

                showAnmtrList.add(showAnimator)

                view.alpha = 0f
            }
        }
    }

    fun hide () {
        hideAnmtrList.forEach {
            it.start()
        }
    }

    fun show () {
        showBackgroundAnmtr.start()
    }

    fun setOnHide (onHide : () -> Unit) {
        this.onHide = onHide
    }

    fun setOnShow (onShow : () -> Unit) {
        this.onShow = onShow
    }
}