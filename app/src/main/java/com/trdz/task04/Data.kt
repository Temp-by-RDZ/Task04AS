package com.trdz.task04

data class Data(val name: String = "Unknown", var number: Int = 0) {

    fun counting(total: Int) {
        if (total > 0) for (i in 1..total) number += i
        else for (i in 0 downTo total) number += i
    }
}

object Database {
    fun save(data: Data): String {
        return data.copy().number.toString()
    }
}

const val KEY_NAME = "NAME"
const val KEY_NUMB = "NUMB"
const val KEY_SAVE = "SAVE"