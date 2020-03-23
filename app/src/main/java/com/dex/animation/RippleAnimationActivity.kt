package com.dex.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.ViewAnimationUtils
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ripple_animation.*
import kotlin.math.hypot

class RippleAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ripple_animation)

        btn_start_ripple.setOnClickListener {
            startAnimation()
        }
    }

    private fun startAnimation() {
        val revealAnim = startRippleAnimation()
        val alphaAnim = getAlphaAnimation()

        val finalAnim = AnimatorSet()
        finalAnim.playTogether(revealAnim, alphaAnim)
        finalAnim.duration = 1000
        finalAnim.start()

    }

    private fun getAlphaAnimation(): Animator {
        return ObjectAnimator.ofArgb(
            ripple_root_layout, "backgroundColor",
            resources.getColor(android.R.color.darker_gray),
            resources.getColor(android.R.color.transparent)
        )
    }

    private fun startRippleAnimation(): Animator {
        val cx = ripple_root_layout.width / 2
        val cy = ripple_root_layout.height / 2
        val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
        return ViewAnimationUtils.createCircularReveal(ripple_root_layout, cx, cy, 0f, finalRadius)
    }


    private fun stopRippleAnimation() {
        val view = findViewById<RelativeLayout>(R.id.ripple_root_layout)
        val cx = view.width / 2
        val cy = view.height / 2
        val initialRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, initialRadius)
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
//                view.setBackgroundColor(Color.parseColor("#00FFFFFF"))
//                view.visibility = View.INVISIBLE
            }
        })
        anim.duration = 1000
        anim.start()
    }
}
