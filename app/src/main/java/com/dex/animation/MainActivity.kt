package com.dex.animation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        btn_lottie.setOnClickListener(this)
        btn_hop_animation.setOnClickListener(this)
        btn_expand_animation.setOnClickListener(this)
        btn_ripple_animation.setOnClickListener(this)
        btn_fade_animation.setOnClickListener(this)
        btn_shared_element_animation.setOnClickListener(this)
        btn_flip_animation.setOnClickListener(this)
        btn_scale_animation.setOnClickListener(this)
        btn_bottom_sheet_animation.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_lottie -> startActivity(Intent(this, LottieActivity::class.java))
            R.id.btn_hop_animation -> startActivity(Intent(this, HopAnimationActivity::class.java))
            R.id.btn_expand_animation -> startActivity(
                Intent(
                    this,
                    ExpandAnimationActivity::class.java
                )
            )
            R.id.btn_ripple_animation -> startActivity(
                Intent(
                    this,
                    RippleAnimationActivity::class.java
                )
            )
            R.id.btn_fade_animation -> startActivity(
                Intent(
                    this,
                    FadeAnimationActivity::class.java
                )
            )
            R.id.btn_shared_element_animation -> startActivity(
                Intent(
                    this,
                    SharedElementAnimationActivity::class.java
                )
            )
            R.id.btn_flip_animation -> startActivity(
                Intent(
                    this, FlipAnimationActivity::class.java
                )
            )
            R.id.btn_scale_animation -> startActivity(
                Intent(this, ScaleAnimationActivity::class.java)
            )
            R.id.btn_bottom_sheet_animation -> startActivity(
                Intent(this, BottomSheetActivity::class.java)
            )
        }
    }
}
