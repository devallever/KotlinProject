package com.allever.app.kotlin.singleton

import android.content.Context

class DCLSingleton(context: Context) {

    fun method() {
        println("DCLSingleton")
    }

    companion object {
        @Volatile
        private var INS: DCLSingleton? = null

        fun getIns(context: Context): DCLSingleton {
            val instance = INS
            if (instance != null) {
                return instance
            }

            return synchronized(this) {
                INS ?: DCLSingleton(context)
            }
        }
    }
}