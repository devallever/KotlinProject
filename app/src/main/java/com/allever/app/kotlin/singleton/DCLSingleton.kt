package com.allever.app.kotlin.singleton

class DCLSingleton() {

    fun method() {
        println("DCLSingleton")
    }

    companion object {
        @Volatile
        private var INS: DCLSingleton? = null

        @JvmStatic
        fun getIns(): DCLSingleton {
            val instance = INS
            if (instance != null) {
                return instance
            }

            return synchronized(this) {
                INS ?: DCLSingleton()
            }
        }
    }
}