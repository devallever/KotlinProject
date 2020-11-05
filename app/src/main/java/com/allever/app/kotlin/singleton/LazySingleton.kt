package com.allever.app.kotlin.singleton

class LazySingleton {

    fun method() {
        println("LazySingleton")
    }

    companion object {
        val INS by lazy {
            LazySingleton()
        }
    }

}