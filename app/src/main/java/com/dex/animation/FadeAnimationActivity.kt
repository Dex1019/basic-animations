package com.dex.animation

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fade_animation.*

class FadeAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fade_animation)

        btn_fade_in.setOnClickListener { startFadeInAnimation() }
        btn_fade_out.setOnClickListener { startFadeOutAnimation() }
    }

    private fun startFadeInAnimation() {
        val animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        animFadeIn.duration = 1000
        ivFadeAnim.startAnimation(animFadeIn)
        animFadeIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                ivFadeAnim.visibility = View.VISIBLE
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        })
    }

    private fun startFadeOutAnimation() {
        val animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        animFadeOut.duration = 1000
        ivFadeAnim.startAnimation(animFadeOut)
        animFadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                ivFadeAnim.visibility = View.INVISIBLE
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        })
    }
}
