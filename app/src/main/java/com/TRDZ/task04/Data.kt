package com.TRDZ.task04

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