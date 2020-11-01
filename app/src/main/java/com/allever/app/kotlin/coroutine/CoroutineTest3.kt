package com.allever.app.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        println("run in scope")
    }
}