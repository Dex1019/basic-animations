package com.dex.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hop_animation.*
import java.util.*
import kotlin.concurrent.timerTask

class HopAnimationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hop_animation)

        Timer().schedule(timerTask { startHopAnimation() }, 0, 1500)
    }


    private fun startHopAnimation() {
        val animation = linearLayoutBottomSheet
            .animate()
            .translationYBy(-40f)
            .setDuration(200)


        animation.withEndAction {
            linearLayoutBottomSheet.animate().translationYBy(40f).duration = 200

        }

    }
}
