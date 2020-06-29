package com.allever.app.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    globalCoroutineLaunchTest()
    runBlockingTest()
    println("run on main")
}

fun globalCoroutineLaunchTest() {
    val job = GlobalScope.launch {
        delay(2000)
        println("run on global scope launch")
    }
}

fun runBlockingTest() {
    //阻塞当前线程
    runBlocking {
        delay(1000)
        println("run on runBlocking")
    }
}