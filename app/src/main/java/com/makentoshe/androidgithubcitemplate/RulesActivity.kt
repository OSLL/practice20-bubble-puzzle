package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rules.info
import kotlinx.android.synthetic.main.activity_rules.restart
import kotlinx.android.synthetic.main.activity_rules.settings

class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)
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