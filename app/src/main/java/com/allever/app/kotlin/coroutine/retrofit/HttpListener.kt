package com.allever.app.kotlin.coroutine.retrofit

interface HttpListener {
    fun onSuccess(result: String)
    fun onFailed(e: Exception)
}