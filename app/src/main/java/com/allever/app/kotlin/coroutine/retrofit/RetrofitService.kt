package com.allever.app.kotlin.coroutine.retrofit

import com.allever.app.kotlin.coroutine.retrofit.RecommendBean
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Allever on 2017/1/15.
 */

interface RetrofitService {
//    @GET("data/allever/recommend/recommend.zh.json")
//    fun getRecommendZh(): Observable<RecommendBean>
//
//    @GET("data/allever/recommend/recommend.en.json")
//    fun getRecommendEn(): Observable<RecommendBean>

    @GET("data/allever/recommend/recommend.zh.json")
    fun getRecommendZh(): Call<RecommendBean>

    @GET("data/allever/recommend/recommend.en.json")
    fun getRecommendEn(): Call<RecommendBean>
}
