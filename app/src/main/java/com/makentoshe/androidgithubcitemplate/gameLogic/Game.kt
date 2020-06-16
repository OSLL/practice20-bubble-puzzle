package com.makentoshe.androidgithubcitemplate.gameLogic

import android.os.CountDownTimer
import kotlin.random.Random
import kotlin.collections.Map

class Game(onTick: (Int) -> Any, private val onFinish: () -> Any) {
    private val board = Board()
    private val timer = Timer(60, onFinish, onTick)
    public var score = 0
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

        this.score += this[x, y]

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

        val count: MutableMap<Int, Int?> = mutableMapOf()
        for (x in 0..7)
            if (count.containsKey(this[x, y]))
                count[this[x, y]] = count[this[x, y]]?.plus(1)
            else
                count[this[x, y]] = 1

        for (v in count.values)
            if (v != null) {
                if (v >= 3) {
                    this.timer.addTime(10)
                    this.reGenerateRow(y)
                    return
                }
            }
    }

    private fun checkColumn(x: Int) {
        if (x !in 0..7)
            return

        val count: MutableMap<Int, Int?> = mutableMapOf()
        for (y in 0..7)
            if (count.containsKey(this[x, y]))
                count[this[x, y]] = count[this[x, y]]?.plus(1)
            else
                count[this[x, y]] = 1

        for (v in count.values)
            if (v != null) {
                if (v >= 3) {
                    this.timer.addTime(10)
                    this.reGenerateColumn(x)
                    return
                }
            }
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

    public fun toJSON() : String {
        var s = "{'timeLost':${this.timer.timeLost},'score':${this.score},'cells':["

        for (x in 0..7)
            for (y in 0..7)
                s += "${this[x, y]},"

        s += "0]}"

        return s
    }
}