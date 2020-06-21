package com.allever.app.kotlin.coroutine.retrofit

import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {

    //请求网络
    runBlocking {
        val result =
            HttpUtil.requestWithSuspendCoroutine(
                ""
            )
    }

    runBlocking {
        //fun <T> create(serviceClass: Class<T>): T = mRetrofit.create(serviceClass)
        val service1 = ServiceController.create(RetrofitService::class.java)

        val service2 = ServiceController.create<RetrofitService>()
        service2.getRecommendZh().enqueue(object : Callback<RecommendBean> {
            override fun onFailure(call: Call<RecommendBean>, t: Throwable) {
                println("fail")
            }

            override fun onResponse(call: Call<RecommendBean>, response: Response<RecommendBean>) {
                println(response.toString())
            }

        })
    }

    runBlocking {
        val service2 = ServiceController.create<RetrofitService>()
        try {
            val result = service2.getRecommendZh().exec()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}

object HttpUtil {

    fun request(address: String, callback: HttpListener?) {

    }

    /***
     * suspendCoroutine：简化回调
     * suspendCoroutine()必须在协程作用域或挂起函数中调用
     * suspendCoroutine()接收一个Lambda表达式，将当前协成立即挂起，然后在普通线程中执行Lambda代码
     * Lambda表达式的参数列表中传入Continuation对象，调用resume()方法或resumeWithException()恢复协程
     */
    suspend fun requestWithSuspendCoroutine(address: String): String {
        return suspendCoroutine { continuation ->
            request(
                address,
                object :
                    HttpListener {
                    override fun onSuccess(result: String) {
                        continuation.resume(result)
                    }

                    override fun onFailed(e: Exception) {
                        continuation.resumeWithException(e)
                    }

                })
        }
    }



}

suspend fun <T> Call<T>.exec(): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (body != null) {
                    continuation.resume(body)
                } else {
                    continuation.resumeWithException(RuntimeException("response body is nul"))
                }

            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })

    }
}