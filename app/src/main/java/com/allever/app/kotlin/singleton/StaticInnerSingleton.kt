package com.allever.app.kotlin.singleton

class StaticInnerSingleton {

    fun method() {
        println("StaticInnerSingleton")
    }

    companion object {
        fun getIns(): StaticInnerSingleton  = Holder.INS
    }

    private object Holder {
        val INS = StaticInnerSingleton()
    }
}