package com.makentoshe.androidgithubcitemplate.gameLogic

import android.os.CountDownTimer
import kotlin.random.Random

class Game(onTick: (Int) -> Any, private val onFinish: () -> Any, time: Int = 60) {
    private val board = Board()
    private val timer = Timer(time, onFinish, onTick)
    public var score = 1000
        set(v) {
            if (v < 0)
                field = 0
            field = v
        }

    init {
        this.generator()
    }

    public operator fun get(x: Int, y: Int): Int {
        return this.board[x, y].value
    }

    public operator fun set(x: Int, y: Int, value: Int) {

        this.board[x, y] = value % 10
    }

    public fun generator() {
        for (x in 0..7)
            for (y in 0..7)
                this[x, y] = Random.nextInt(1, 9)
    }

    public fun increment(x: Int, y: Int) {
        this[x - 1, y] += this[x, y]
        this[x, y - 1] += this[x, y]
        this[x + 1, y] += this[x, y]
        this[x, y + 1] += this[x, y]

        this.score -= this[x, y]

        this.checkRow(y - 1)
        this.checkRow(y)
        this.checkRow(y + 1)
        this.checkColumn(x - 1)
        this.checkColumn(x)
        this.checkColumn(x + 1)
    }

    private fun checkRow(y: Int) {
        if (y !in 0..7)
            return

        val key = this[0, y]
        for (x in 1..7)
            if (this[x, y] != key)
                return

        this.timer.addTime(10)
        this.score += 100
        this.reGenerateRow(y)
    }

    private fun checkColumn(x: Int) {
        if (x !in 0..7)
            return

        val key = this[x, 0]
        for (y in 1..7)
            if (this[x, y] != key)
                return

        this.timer.addTime(10)
        this.score += 100
        this.reGenerateColumn(x)
    }

    private fun reGenerateRow(y: Int) {
        for (x in 0..7)
            this[x, y] = Random.nextInt(1, 9)
    }

    private fun reGenerateColumn(x: Int) {
        for (y in 0..7)
            this[x, y] = Random.nextInt(1, 9)
    }

    public fun startTimer() {
        this.timer.start()
    }

    public fun stopTimer() {
        this.timer.stop()
    }

    public fun export(): String {
        var s = "${this.timer.timeLost}&${this.score}"

        for (x in 0..7)
            for (y in 0..7)
                s += "&${this[x, y]}"

        return s + "&"
    }

    companion object {
        fun import(s: String, onTick: (Int) -> Any, onFinish: () -> Any): Game {
            var i = 0
            var v = ""
            while (s[i] != '&') {
                v += s[i++]
            }
            val o = Game(onTick, onFinish, v.toInt())
            i++

            v = ""
            while (s[i] != '&') {
                v += s[i++]
            }
            o.score = v.toInt()
            i++

            for (x in 0..7)
                for (y in 0..7) {
                    while (s[i] != '&') {
                        v += s[i++]
                    }
                    o[x, y] = v.toInt()
                    i++
                }
            return o
        }
    }
}