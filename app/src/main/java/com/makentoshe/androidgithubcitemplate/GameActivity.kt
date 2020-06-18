package com.makentoshe.androidgithubcitemplate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.makentoshe.androidgithubcitemplate.gameLogic.Game
import kotlinx.android.synthetic.main.activity_game.*

var secondsTimer: String = ""


class GameActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    private fun onTick(timeLost: Int) {
        val minutes: Int = timeLost / 60
        val seconds = timeLost % 60
        secondsTimer = if(seconds < 10) {
            "0$seconds"
        } else {
            "$seconds"
        }

        this.textTimeLost.text = "$minutes:$secondsTimer"
    }

    private fun onFinish() {
        resultScore = this.gameApi.score
        val goToResult = Intent(this, ResultActivity::class.java)
        startActivity(goToResult)
    }

    private val gameApi = Game({ i -> onTick(i) }, { onFinish() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        info.setOnClickListener {
            gameApi.stopTimer()
            val goToRules = Intent(this, RulesActivity::class.java)
            startActivity(goToRules)
        }
        restart.setOnClickListener {
            gameApi.stopTimer()
            val goToRestart = Intent(this, GameActivity::class.java)
            startActivity(goToRestart)
        }
        settings.setOnClickListener {
            val goToSettings = Intent(this, SettingsActivity::class.java)
            gameApi.stopTimer()
            startActivity(goToSettings)
        }

        /*
            script-generated code

            # python 3
            for y in range(8):
                for x in range(8):
                    print("""        cell_%d_%d.setOnClickListener {
                        this.gameApi.increment(%d, %d)
                        this.updateButtonsValues()
                }""" % (y, x, x, y))
         */
        cell_0_0.setOnClickListener {
            this.gameApi.increment(0, 0)
            this.updateButtonsValues()
        }
        cell_0_1.setOnClickListener {
            this.gameApi.increment(1, 0)
            this.updateButtonsValues()
        }
        cell_0_2.setOnClickListener {
            this.gameApi.increment(2, 0)
            this.updateButtonsValues()
        }
        cell_0_3.setOnClickListener {
            this.gameApi.increment(3, 0)
            this.updateButtonsValues()
        }
        cell_0_4.setOnClickListener {
            this.gameApi.increment(4, 0)
            this.updateButtonsValues()
        }
        cell_0_5.setOnClickListener {
            this.gameApi.increment(5, 0)
            this.updateButtonsValues()
        }
        cell_0_6.setOnClickListener {
            this.gameApi.increment(6, 0)
            this.updateButtonsValues()
        }
        cell_0_7.setOnClickListener {
            this.gameApi.increment(7, 0)
            this.updateButtonsValues()
        }
        cell_1_0.setOnClickListener {
            this.gameApi.increment(0, 1)
            this.updateButtonsValues()
        }
        cell_1_1.setOnClickListener {
            this.gameApi.increment(1, 1)
            this.updateButtonsValues()
        }
        cell_1_2.setOnClickListener {
            this.gameApi.increment(2, 1)
            this.updateButtonsValues()
        }
        cell_1_3.setOnClickListener {
            this.gameApi.increment(3, 1)
            this.updateButtonsValues()
        }
        cell_1_4.setOnClickListener {
            this.gameApi.increment(4, 1)
            this.updateButtonsValues()
        }
        cell_1_5.setOnClickListener {
            this.gameApi.increment(5, 1)
            this.updateButtonsValues()
        }
        cell_1_6.setOnClickListener {
            this.gameApi.increment(6, 1)
            this.updateButtonsValues()
        }
        cell_1_7.setOnClickListener {
            this.gameApi.increment(7, 1)
            this.updateButtonsValues()
        }
        cell_2_0.setOnClickListener {
            this.gameApi.increment(0, 2)
            this.updateButtonsValues()
        }
        cell_2_1.setOnClickListener {
            this.gameApi.increment(1, 2)
            this.updateButtonsValues()
        }
        cell_2_2.setOnClickListener {
            this.gameApi.increment(2, 2)
            this.updateButtonsValues()
        }
        cell_2_3.setOnClickListener {
            this.gameApi.increment(3, 2)
            this.updateButtonsValues()
        }
        cell_2_4.setOnClickListener {
            this.gameApi.increment(4, 2)
            this.updateButtonsValues()
        }
        cell_2_5.setOnClickListener {
            this.gameApi.increment(5, 2)
            this.updateButtonsValues()
        }
        cell_2_6.setOnClickListener {
            this.gameApi.increment(6, 2)
            this.updateButtonsValues()
        }
        cell_2_7.setOnClickListener {
            this.gameApi.increment(7, 2)
            this.updateButtonsValues()
        }
        cell_3_0.setOnClickListener {
            this.gameApi.increment(0, 3)
            this.updateButtonsValues()
        }
        cell_3_1.setOnClickListener {
            this.gameApi.increment(1, 3)
            this.updateButtonsValues()
        }
        cell_3_2.setOnClickListener {
            this.gameApi.increment(2, 3)
            this.updateButtonsValues()
        }
        cell_3_3.setOnClickListener {
            this.gameApi.increment(3, 3)
            this.updateButtonsValues()
        }
        cell_3_4.setOnClickListener {
            this.gameApi.increment(4, 3)
            this.updateButtonsValues()
        }
        cell_3_5.setOnClickListener {
            this.gameApi.increment(5, 3)
            this.updateButtonsValues()
        }
        cell_3_6.setOnClickListener {
            this.gameApi.increment(6, 3)
            this.updateButtonsValues()
        }
        cell_3_7.setOnClickListener {
            this.gameApi.increment(7, 3)
            this.updateButtonsValues()
        }
        cell_4_0.setOnClickListener {
            this.gameApi.increment(0, 4)
            this.updateButtonsValues()
        }
        cell_4_1.setOnClickListener {
            this.gameApi.increment(1, 4)
            this.updateButtonsValues()
        }
        cell_4_2.setOnClickListener {
            this.gameApi.increment(2, 4)
            this.updateButtonsValues()
        }
        cell_4_3.setOnClickListener {
            this.gameApi.increment(3, 4)
            this.updateButtonsValues()
        }
        cell_4_4.setOnClickListener {
            this.gameApi.increment(4, 4)
            this.updateButtonsValues()
        }
        cell_4_5.setOnClickListener {
            this.gameApi.increment(5, 4)
            this.updateButtonsValues()
        }
        cell_4_6.setOnClickListener {
            this.gameApi.increment(6, 4)
            this.updateButtonsValues()
        }
        cell_4_7.setOnClickListener {
            this.gameApi.increment(7, 4)
            this.updateButtonsValues()
        }
        cell_5_0.setOnClickListener {
            this.gameApi.increment(0, 5)
            this.updateButtonsValues()
        }
        cell_5_1.setOnClickListener {
            this.gameApi.increment(1, 5)
            this.updateButtonsValues()
        }
        cell_5_2.setOnClickListener {
            this.gameApi.increment(2, 5)
            this.updateButtonsValues()
        }
        cell_5_3.setOnClickListener {
            this.gameApi.increment(3, 5)
            this.updateButtonsValues()
        }
        cell_5_4.setOnClickListener {
            this.gameApi.increment(4, 5)
            this.updateButtonsValues()
        }
        cell_5_5.setOnClickListener {
            this.gameApi.increment(5, 5)
            this.updateButtonsValues()
        }
        cell_5_6.setOnClickListener {
            this.gameApi.increment(6, 5)
            this.updateButtonsValues()
        }
        cell_5_7.setOnClickListener {
            this.gameApi.increment(7, 5)
            this.updateButtonsValues()
        }
        cell_6_0.setOnClickListener {
            this.gameApi.increment(0, 6)
            this.updateButtonsValues()
        }
        cell_6_1.setOnClickListener {
            this.gameApi.increment(1, 6)
            this.updateButtonsValues()
        }
        cell_6_2.setOnClickListener {
            this.gameApi.increment(2, 6)
            this.updateButtonsValues()
        }
        cell_6_3.setOnClickListener {
            this.gameApi.increment(3, 6)
            this.updateButtonsValues()
        }
        cell_6_4.setOnClickListener {
            this.gameApi.increment(4, 6)
            this.updateButtonsValues()
        }
        cell_6_5.setOnClickListener {
            this.gameApi.increment(5, 6)
            this.updateButtonsValues()
        }
        cell_6_6.setOnClickListener {
            this.gameApi.increment(6, 6)
            this.updateButtonsValues()
        }
        cell_6_7.setOnClickListener {
            this.gameApi.increment(7, 6)
            this.updateButtonsValues()
        }
        cell_7_0.setOnClickListener {
            this.gameApi.increment(0, 7)
            this.updateButtonsValues()
        }
        cell_7_1.setOnClickListener {
            this.gameApi.increment(1, 7)
            this.updateButtonsValues()
        }
        cell_7_2.setOnClickListener {
            this.gameApi.increment(2, 7)
            this.updateButtonsValues()
        }
        cell_7_3.setOnClickListener {
            this.gameApi.increment(3, 7)
            this.updateButtonsValues()
        }
        cell_7_4.setOnClickListener {
            this.gameApi.increment(4, 7)
            this.updateButtonsValues()
        }
        cell_7_5.setOnClickListener {
            this.gameApi.increment(5, 7)
            this.updateButtonsValues()
        }
        cell_7_6.setOnClickListener {
            this.gameApi.increment(6, 7)
            this.updateButtonsValues()
        }
        cell_7_7.setOnClickListener {
            this.gameApi.increment(7, 7)
            this.updateButtonsValues()
        }

        this.updateButtonsValues()
        this.gameApi.startTimer()
    }

    private fun updateButtonsValues() {
        textPointsGained.text = this.gameApi.score.toString()

        /*
            script-generated code

            # python 3
            for y in range(8):
                for x in range(8):
                    print("cell_%d_%d.text = this.gameApi[%d, %d].toString()" % (y, x, x, y))
         */
        cell_0_0.text = this.gameApi[0, 0].toString()
        cell_0_1.text = this.gameApi[1, 0].toString()
        cell_0_2.text = this.gameApi[2, 0].toString()
        cell_0_3.text = this.gameApi[3, 0].toString()
        cell_0_4.text = this.gameApi[4, 0].toString()
        cell_0_5.text = this.gameApi[5, 0].toString()
        cell_0_6.text = this.gameApi[6, 0].toString()
        cell_0_7.text = this.gameApi[7, 0].toString()
        cell_1_0.text = this.gameApi[0, 1].toString()
        cell_1_1.text = this.gameApi[1, 1].toString()
        cell_1_2.text = this.gameApi[2, 1].toString()
        cell_1_3.text = this.gameApi[3, 1].toString()
        cell_1_4.text = this.gameApi[4, 1].toString()
        cell_1_5.text = this.gameApi[5, 1].toString()
        cell_1_6.text = this.gameApi[6, 1].toString()
        cell_1_7.text = this.gameApi[7, 1].toString()
        cell_2_0.text = this.gameApi[0, 2].toString()
        cell_2_1.text = this.gameApi[1, 2].toString()
        cell_2_2.text = this.gameApi[2, 2].toString()
        cell_2_3.text = this.gameApi[3, 2].toString()
        cell_2_4.text = this.gameApi[4, 2].toString()
        cell_2_5.text = this.gameApi[5, 2].toString()
        cell_2_6.text = this.gameApi[6, 2].toString()
        cell_2_7.text = this.gameApi[7, 2].toString()
        cell_3_0.text = this.gameApi[0, 3].toString()
        cell_3_1.text = this.gameApi[1, 3].toString()
        cell_3_2.text = this.gameApi[2, 3].toString()
        cell_3_3.text = this.gameApi[3, 3].toString()
        cell_3_4.text = this.gameApi[4, 3].toString()
        cell_3_5.text = this.gameApi[5, 3].toString()
        cell_3_6.text = this.gameApi[6, 3].toString()
        cell_3_7.text = this.gameApi[7, 3].toString()
        cell_4_0.text = this.gameApi[0, 4].toString()
        cell_4_1.text = this.gameApi[1, 4].toString()
        cell_4_2.text = this.gameApi[2, 4].toString()
        cell_4_3.text = this.gameApi[3, 4].toString()
        cell_4_4.text = this.gameApi[4, 4].toString()
        cell_4_5.text = this.gameApi[5, 4].toString()
        cell_4_6.text = this.gameApi[6, 4].toString()
        cell_4_7.text = this.gameApi[7, 4].toString()
        cell_5_0.text = this.gameApi[0, 5].toString()
        cell_5_1.text = this.gameApi[1, 5].toString()
        cell_5_2.text = this.gameApi[2, 5].toString()
        cell_5_3.text = this.gameApi[3, 5].toString()
        cell_5_4.text = this.gameApi[4, 5].toString()
        cell_5_5.text = this.gameApi[5, 5].toString()
        cell_5_6.text = this.gameApi[6, 5].toString()
        cell_5_7.text = this.gameApi[7, 5].toString()
        cell_6_0.text = this.gameApi[0, 6].toString()
        cell_6_1.text = this.gameApi[1, 6].toString()
        cell_6_2.text = this.gameApi[2, 6].toString()
        cell_6_3.text = this.gameApi[3, 6].toString()
        cell_6_4.text = this.gameApi[4, 6].toString()
        cell_6_5.text = this.gameApi[5, 6].toString()
        cell_6_6.text = this.gameApi[6, 6].toString()
        cell_6_7.text = this.gameApi[7, 6].toString()
        cell_7_0.text = this.gameApi[0, 7].toString()
        cell_7_1.text = this.gameApi[1, 7].toString()
        cell_7_2.text = this.gameApi[2, 7].toString()
        cell_7_3.text = this.gameApi[3, 7].toString()
        cell_7_4.text = this.gameApi[4, 7].toString()
        cell_7_5.text = this.gameApi[5, 7].toString()
        cell_7_6.text = this.gameApi[6, 7].toString()
        cell_7_7.text = this.gameApi[7, 7].toString()
    }

}