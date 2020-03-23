package com.dex.animation

import android.animation.Animator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lottie.*

class LottieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)
        initLottieAnimation()
        clickListeners()
    }

    private fun initLottieAnimation() {
        lottieAnimationView.setAnimation("cycling.json")
        lottieAnimationView.speed = 0.5f

        // Animation listener
        lottieAnimationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }

        })
    }

    private fun clickListeners() {
        lottieAnimationView!!.setOnClickListener { startCheckAnimation() }
    }

    private fun startCheckAnimation() {
        lottieAnimationView?.let {
            if (lottieAnimationView.isAnimating) {
                lottieAnimationView.pauseAnimation()
            } else {
                lottieAnimationView.playAnimation()
            }
        }
    }
}
