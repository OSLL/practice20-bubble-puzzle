package com.makentoshe.androidgithubcitemplate.gameLogic

import kotlin.random.Random

class Game {
    private val board = Board()

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
        this[x + 1, y] += 1
        this[x, y + 1] += 1
        this[x - 1, y] += 1
        this[x, y - 1] += 1

        this.checkRow(y - 1)
        this.checkRow(y + 1)
        this.checkColumn(x - 1)
        this.checkColumn(x + 1)
    }

    private fun checkRow(y: Int) {
        val key = this[y, 0]
        for (x in 1..7)
            if (this[y, x] != key)
                return

        this.reGenerateRow(y)
    }

    private fun checkColumn(x: Int) {
        val key = this[0, x]
        for (y in 1..7)
            if (this[y, x] != key)
                return

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
}