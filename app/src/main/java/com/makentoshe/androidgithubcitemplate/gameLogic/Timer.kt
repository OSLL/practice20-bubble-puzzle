package com.makentoshe.androidgithubcitemplate.gameLogic

import android.os.CountDownTimer

class Timer(time: Int, private val onFinish: () -> Any, private val onTick: (Int) -> Any) {
    private class TimerClass(time: Int, private val master: Timer) :
        CountDownTimer((time * 1000).toLong(), 1000) {
        override fun onFinish() {
            this.master.onFinish()
        }

        override fun onTick(millisUntilFinished: Long) {
            this.master._timeLost = (millisUntilFinished / 1000).toInt()
            this.master.onTick(this.master._timeLost)
        }
    }

    private var timerObject = TimerClass(time, this)
    private var _timeLost: Int = time
    private var isStarted: Boolean = false
    public val timeLost: Int
        get() {
            return this._timeLost
        }

    public fun addTime(time: Int) {
        if (this.isStarted)
            this.timerObject.cancel()
        this._timeLost += time
        this.timerObject = TimerClass(this._timeLost, this)
        if (this.isStarted)
            this.timerObject.start()
    }

    public fun start() {
        this.isStarted = true
        this.timerObject.start()
    }

    public fun stop() {
        this.isStarted = false
        this.timerObject.cancel()
    }
}