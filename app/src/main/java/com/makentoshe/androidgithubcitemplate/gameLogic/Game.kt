package com.makentoshe.androidgithubcitemplate.gameLogic

import android.os.CountDownTimer
import kotlin.random.Random

class Game(onTick: (Int) -> Any, private val onFinish: () -> Any) {
    private val board = Board()
    private val timer = Timer(60, onFinish, onTick)

    init {
        this.generator()
    }

    public operator fun get(x: Int, y: Int): Int {
        return this.board[x, y].value
    }

    public operator fun set(x: Int, y: Int, value: Int) {

        this.board[x, y] = value
    }

    public fun generator() {
        for (x in 0..7)
            for (y in 0..7)
                this[x, y] = Random.nextInt(1, 9)
    }

    public fun increment(x: Int, y: Int) {
        this[x + 1, y] += this[x, y]
        this[x, y + 1] += this[x, y]
        this[x - 1, y] += this[x, y]
        this[x, y - 1] += this[x, y]

        this.checkRow(y - 1)
        this.checkRow(y + 1)
        this.checkColumn(x - 1)
        this.checkColumn(x + 1)
    }

    private fun checkRow(y: Int) {
        if (y !in 0..7)
            return

        val key = this[y, 0]
        for (x in 1..7)
            if (this[x, y] != key)
                return

        this.timer.addTime(10)
        this.reGenerateRow(y)
    }

    private fun checkColumn(x: Int) {
        if (x !in 0..7)
            return

        val key = this[0, x]
        for (y in 1..7)
            if (this[x, y] != key)
                return

        this.timer.addTime(10)
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
}