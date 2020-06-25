package com.makentoshe.androidgithubcitemplate.gameLogic
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout

class Animation {
    companion object{
        fun ChangeBackgroundColour(screen : ConstraintLayout, currentColor : Color) {
            val objectAnimator: ObjectAnimator =
                ObjectAnimator.ofInt(screen, "backgroundColor", Color.RED, Color.BLUE)
                    .setDuration(250)
            objectAnimator.setEvaluator(ArgbEvaluator())
            objectAnimator.start()
        }
    }
}