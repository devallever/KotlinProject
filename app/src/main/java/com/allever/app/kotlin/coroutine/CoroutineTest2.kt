package com.allever.app.kotlin.coroutine

import kotlinx.coroutines.*

private val mCoroutineJob = Job()
private val mGlobalCoroutineScope = CoroutineScope(mCoroutineJob)

fun main() {
    globalCoroutineLaunchTest()
    runBlockingTest()
    launchCoroutineTest()
    runBlocking {
        createCoroutineWithCoroutineScopeTest()
    }
    createCoroutineWithCoroutineScopeTest2()
    mGlobalCoroutineScope.launch {
        delay(1000)
        println("run on mGlobalCoroutineScope 1")
    }
    mGlobalCoroutineScope.launch {
        delay(1500)
        println("run on mGlobalCoroutineScope 2")
    }
    mCoroutineJob.cancel()
    Thread.sleep(2000)
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

suspend fun createCoroutineWithCoroutineScopeTest()  = coroutineScope {
    launch {
        println("run on coroutineScope")
    }
}

fun createCoroutineWithCoroutineScopeTest2() {
    runBlocking {
        coroutineScope {
            delay(1000)
            println("run on coroutineScope 1")
        }

        coroutineScope {
            delay(1000)
            println("run on coroutineScope 2")
        }
        println("run on outer coroutine")
    }
}