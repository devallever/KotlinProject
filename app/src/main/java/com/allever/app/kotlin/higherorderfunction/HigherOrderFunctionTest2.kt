package com.allever.app.kotlin.higherorderfunction

fun main() {
    //lambda参数方式传入
    val lambdaResult = {
        1 + 1
    }
    simpleHigherFunTest2(lambdaResult)
    simpleHigherFunTest2 {
        1 + 1
    }

    val lambda = { }
    simpleHigherFunTest1(lambda)
    simpleHigherFunTest1({})
    simpleHigherFunTest1 {  }
}

fun simpleHigherFunTest1(block: () -> Unit) {
    //执行Lambda代码块
    block()
}

fun simpleHigherFunTest2(block: () -> Int) {
    //执行Lambda代码块
    block()
}