package com.makentoshe.androidgithubcitemplate.gameLogic


class Board {
    private val buffer = Array<BoardCell>(8 * 8) { BoardCell() }

    public operator fun get(x: Int, y: Int): BoardCell {
        if (y !in 0..7 || x !in 0..7)
            return BoardCell() // index error suppression

        return this.buffer[y * 8 + x]
    }

    public operator fun set(x: Int, y: Int, value: Int) {
        if (y !in 0..7 || x !in 0..7)
            return // index error suppression

        this[x, y].value = value
    }
}