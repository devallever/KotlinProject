package com.allever.app.kotlin.delegate

fun main() {
    val p by Delegate()
    p?.name = "Allever"
    println("name = ${p?.name}")
}