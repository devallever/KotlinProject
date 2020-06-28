package com.allever.app.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlockingTest()
    globalCoroutineLaunchTest()
    Thread.sleep(1000)
    println("run on main")
}

fun globalCoroutineLaunchTest() {
    val job = GlobalScope.launch {
        println("run on global scope launch")
        delay(200)
        println("run on global scope launch finish")
    }
}

fun runBlockingTest() {
    //阻塞当前线程
    runBlocking {
        delay(3000)
        println("run on runBlocking")
    }
}