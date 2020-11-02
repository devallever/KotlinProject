package com.allever.app.kotlin

import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivImageView.load(R.mipmap.ic_launcher)


        coroutineTest()
    }

    private fun coroutineTest() {
        GlobalScope.launch (Dispatchers.Main){
            val resultIO = withContext(Dispatchers.IO) {
                log("withContext IO")
                delay(5000)
                log("withContext IO end")
                1
            }
            log("withContext Main MainStart")
            val resultMain = withContext(Dispatchers.Main) {
                log("withContext Main")
                delay(1000)
                log("withContext Main end")
                2
            }

            log("result IO + result Main = ${resultIO + resultMain}")


            val deferred2 = async(Dispatchers.Main) {
                delay(1000)
                log("${isMainThread()}")
                2
            }

            val deferred1 = async(Dispatchers.IO) {
                delay(1000)
                log("${isMainThread()}")
                1
            }

            val deferredResult = deferred1.await() + deferred2.await()
            log("deferredResult = $deferredResult")
            log("${isMainThread()}")
        }

        log("outer coroutine")
    }

    private fun log(msg: String) {
        Log.d(MainActivity::class.java.simpleName, msg)
    }

    private fun isMainThread(): Boolean {
        return Looper.getMainLooper().thread.id == Thread.currentThread().id
    }
}
