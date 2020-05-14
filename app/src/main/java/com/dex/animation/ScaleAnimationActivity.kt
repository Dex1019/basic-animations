package com.dex.animation

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scale_animation.*

class ScaleAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scale_animation)

        btnStart.setOnClickListener {
            val scaleIn = ScaleAnimation(
                0f,
                1f,
                0f,
                1f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                -0.3f
            )
            scaleIn.duration = 500
            scaleIn.fillAfter = true
//            iv_shape_triangle.startAnimation(scaleIn)
            ivScaleImage.startAnimation(scaleIn)


            val scaleInTri = ScaleAnimation(
                0f,
                1f,
                0f,
                1f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                -0.3f
            )
            scaleInTri.duration = 530
            scaleInTri.fillAfter = true
            iv_shape_triangle.startAnimation(scaleInTri)

        }

        btnStop.setOnClickListener {

            val scaleOut = ScaleAnimation(
                1f,
                0f,
                1f,
                0f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                -0.3f
            )
            scaleOut.duration = 500
            scaleOut.fillAfter = true

//            iv_shape_triangle.startAnimation(scaleOut)
            ivScaleImage.startAnimation(scaleOut)

            val scaleOutTri = ScaleAnimation(
                1f,
                0f,
                1f,
                0f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                -0.3f
            )
            scaleOutTri.duration = 410
            scaleOutTri.fillAfter = true
            iv_shape_triangle.startAnimation(scaleOutTri)



        }


    }
}