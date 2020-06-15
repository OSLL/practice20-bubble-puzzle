package com.makentoshe.androidgithubcitemplate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.makentoshe.androidgithubcitemplate.gameLogic.Game
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    private fun onTick(timeLost: Int) {
        val minutes: Int = timeLost / 60
        val seconds = timeLost % 60

        this.textTimeLost.text = "$minutes:$seconds"
    }

    private fun onFinish() {
        val goToRestart = Intent(this, GameActivity::class.java)
        startActivity(goToRestart)
    }

    private val gameApi = Game({ i -> onTick(i) }, { onFinish() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
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


}