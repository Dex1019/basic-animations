package com.dex.animation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.activity_shared_element_animation.*

class SharedElementAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element_animation)

        val p1 = Pair.create<View, String>(imageM, "imageMain")
        val p2 = Pair.create<View, String>(sampelText, "textMain")
        imageM.setOnClickListener {
            val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, p1, p2
            )

            val intent = Intent(this, DetailSharedElementActivity::class.java)
            startActivity(intent, activityOptionsCompat.toBundle())
        }
    }
}
