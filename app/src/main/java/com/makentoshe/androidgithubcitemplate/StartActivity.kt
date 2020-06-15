package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        PlayButton.setOnClickListener{
            startActivity(Intent(this, GameActivity::class.java))
        }
        HelpText.setOnClickListener{
            startActivity(Intent(this, RulesActivity::class.java))
        }
    }
}