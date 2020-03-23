package com.dex.animation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import kotlinx.android.synthetic.main.activity_expand_animation.*

class ExpandAnimationActivity : AppCompatActivity() {

    private lateinit var expandableTextView: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand_animation)

        expandableTextView = findViewById(R.id.tv_sample_text)
        var height = 0
        expandableTextView.visibility = VISIBLE
        expandableTextView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                println("===> view tree : ${expandableTextView.measuredHeight}")
                height = expandableTextView.measuredHeight
                expandableTextView.visibility = GONE
                expandableTextView.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })

//        expandableTextView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
//        expandableTextView.layout(0, 0, expandableTextView.measuredWidth, expandableTextView.measuredHeight)
//        val height = expandableTextView.measuredHeight
//
//        println("===> measure tree : ${expandableTextView.measuredHeight}")

        tv_expandable_view.setOnClickListener {
            if (expandableTextView.visibility == VISIBLE) {
                collapseExpandableView(height)
            } else {
                showExpandableView(height)
            }
        }
    }

    private fun showExpandableView(height: Int) {
        ivExpandView.setImageResource(R.drawable.ic_arrow_up)
        expandableTextView.visibility = VISIBLE
        val animator = ObjectAnimator.ofInt(expandableTextView, "translationY", 0, height)
        animator.duration = 500
        animator.addUpdateListener { expandableViewHeight(animator) }
        animator.start()
    }

    private fun collapseExpandableView(height: Int) {
        ivExpandView.setImageResource(R.drawable.ic_arrow_down)
        val animator = ObjectAnimator.ofInt(expandableTextView, "translationY", height, 0)
        animator.duration = 500
        animator.addUpdateListener { expandableViewHeight(animator) }
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                expandableTextView.visibility = GONE
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {
            }

        })
        animator.start()
    }

    private fun expandableViewHeight(animator: ObjectAnimator) {
        val height = animator.animatedValue
        tv_sample_text.layoutParams.height = height as Int
        tv_sample_text.requestLayout()
    }
}
