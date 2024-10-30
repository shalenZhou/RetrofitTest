package com.example.retrofittest.service

import com.example.retrofittest.data.App
import retrofit2.Call
import retrofit2.http.GET

// 通常Retroﬁt的接口文件建议以具体的功能种类名开头，并以Service结尾
interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
}