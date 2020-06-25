package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.makentoshe.androidgithubcitemplate.gameLogic.Animation
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        changeColorsBackground.text = if (Animation.makeAnimation) "Не менять фон" else "Менять фон"
        changeColorsBackground.setOnClickListener {
            Animation.makeAnimation =  !Animation.makeAnimation
            Animation.currentBackgroundColor = Color.WHITE
            changeColorsBackground.text = if (Animation.makeAnimation) "Не менять фон" else "Менять фон"
        }
        info.setOnClickListener {
            val goToRules = Intent(this, RulesActivity::class.java)
            startActivity(goToRules)
        }
        restart.setOnClickListener {
            val goToRestart = Intent(this, GameActivity::class.java)
            startActivity(goToRestart)
        }
        settings.setOnClickListener {
            val goToSettings = Intent(this, SettingsActivity::class.java)
            startActivity(goToSettings)
        }
    }
    override fun onBackPressed() {
    }
}