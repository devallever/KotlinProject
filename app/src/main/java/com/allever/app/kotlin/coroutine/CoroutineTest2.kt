package com.allever.app.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    globalCoroutineLaunchTest()
    runBlockingTest()
    launchCoroutineTest()
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
        delay(1000)
        println("run on runBlocking")
    }
}

fun launchCoroutineTest() {
    runBlocking {
        launch {
            println("run on launch 1")
            suspendFunTest()
            noneSuspendFunTest()
        }

        launch {
            println("run on launch 2")
            suspendFunTest()
            noneSuspendFunTest()
        }
    }
}

fun noneSuspendFunTest() {
    //deley(1000)
    println("cant run on suspend fun")
}

suspend fun suspendFunTest() {
    delay(1000)
    println("run on suspend fun")
}