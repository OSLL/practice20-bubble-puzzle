package com.makentoshe.androidgithubcitemplate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

var resultScore: Int = 0

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        info.setOnClickListener {
            val goToRules = Intent(this, RulesActivity::class.java)
            startActivity(goToRules)
            finish()
        }
        restart.setOnClickListener {
            val goToRestart = Intent(this, GameActivity::class.java)
            startActivity(goToRestart)
            finish()
        }
        settings.setOnClickListener {
            val goToSettings = Intent(this, SettingsActivity::class.java)
            startActivity(goToSettings)
            finish()
        }

        result.text = "Ваш результат: $resultScore"
    }
    override fun onBackPressed() {
    }
}