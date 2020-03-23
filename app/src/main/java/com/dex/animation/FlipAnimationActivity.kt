package com.dex.animation

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_flip_animation.*

class FlipAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flip_animation)
        setupTextSwitcher()

        btnFlipText1.setOnClickListener { textSwitcher.setText("Hello World") }
        btnFlipText2.setOnClickListener { textSwitcher.setText("Text switch animation") }
    }

    private fun setupTextSwitcher() {
        textSwitcher.setFactory {
            val textView = TextView(this)
            textView.textSize = 18f
            textView.gravity = Gravity.CENTER
            textView.text = "Sample Text"
            textView.setTextColor(resources.getColor(android.R.color.black))
            textView
        }
        textSwitcher.setInAnimation(this, R.anim.slide_in_bottom);
        textSwitcher.setOutAnimation(this, R.anim.slide_out_top);
    }
}
