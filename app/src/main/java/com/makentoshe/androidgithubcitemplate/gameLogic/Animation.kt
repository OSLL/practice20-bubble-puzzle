package com.makentoshe.androidgithubcitemplate.gameLogic
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class Animation {
    companion object{
        var makeAnimation = true
        var currentBackgroundColor = Color.WHITE
        fun ChangeBackgroundColour(screen : ConstraintLayout) {
            if (!makeAnimation){
                currentBackgroundColor = Color.WHITE
                return
            }
            var newColor = Color.argb(
                255,
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
            val objectAnimator: ObjectAnimator =
                ObjectAnimator.ofInt(screen, "backgroundColor", currentBackgroundColor, newColor)
                    .setDuration(500)
            objectAnimator.setEvaluator(ArgbEvaluator())
            objectAnimator.start()
            currentBackgroundColor = newColor
        }
        fun ChangeTileSize (tile: Button){

        }
    }
}