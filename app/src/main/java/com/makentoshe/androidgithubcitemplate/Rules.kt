package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rules.*
import kotlinx.android.synthetic.main.activity_rules.info
import kotlinx.android.synthetic.main.activity_rules.restart
import kotlinx.android.synthetic.main.activity_rules.settings
import kotlinx.android.synthetic.main.activity_settings.*

class Rules : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)
        info.setOnClickListener {
            val goToRules = Intent(this, Rules::class.java)
            startActivity(goToRules)
        }
        restart.setOnClickListener {
            val goToRestart = Intent(this, MainActivity::class.java)
            startActivity(goToRestart)
        }
        settings.setOnClickListener {
            val goToSettings = Intent(this, Settings::class.java)
            startActivity(goToSettings)
        }
    }
}