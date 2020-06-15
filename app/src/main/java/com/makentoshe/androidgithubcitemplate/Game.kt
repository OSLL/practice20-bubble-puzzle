package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*

class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        info.setOnClickListener {
            val goToRules = Intent(this, Rules::class.java)
            startActivity(goToRules)
        }
        restart.setOnClickListener {
            val goToRestart = Intent(this, Game::class.java)
            startActivity(goToRestart)
        }
        settings.setOnClickListener {
            val goToSettings = Intent(this, Settings::class.java)
            startActivity(goToSettings)
        }
    }


}