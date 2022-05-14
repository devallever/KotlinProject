package com.allever.app.kotlin.singleton

fun main() {
    HungrySingleton.method()
    LazySingleton.INS.method()
    DCLSingleton.getIns().method()
    StaticInnerSingleton.getIns().method()
}