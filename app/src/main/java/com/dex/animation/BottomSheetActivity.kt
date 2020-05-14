package com.dex.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.*


class BottomSheetActivity : AppCompatActivity() {

    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        var behavior = BottomSheetBehavior.from(bottom_sheet_layout)
        behavior.state = BottomSheetBehavior.STATE_HIDDEN

        view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)

        btn_bottomsheet.setOnClickListener {
//            if (behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
//                behavior.setState(BottomSheetBehavior.STATE_EXPANDED)
//            } else {
//                behavior.setState(BottomSheetBehavior.STATE_HIDDEN)
//            }


//            val bottomSheetFragment = BottomSheetFragment()
//            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)


//            setEntryAnimation()
//            getDialog().getWindow()
//                .getAttributes().windowAnimations =
            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
            dialog.show()
//            val lp = WindowManager.LayoutParams()
//            lp.copyFrom(dialog.window?.attributes)
//            lp.width = WindowManager.LayoutParams.MATCH_PARENT
//            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
//            lp.gravity = Gravity.BOTTOM
//            lp.windowAnimations = R.style.DialogAnim
//            dialog.window?.attributes = lp
//            dialog.show()
        }

        behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // React to state change
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
            }
        })
    }

    private fun setEntryAnimation() {
        val animator = ObjectAnimator.ofFloat(view, "translationY", 200f, 1f)
        animator.duration = 1000
        animator.start()
    }
}
