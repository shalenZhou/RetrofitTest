package com.example.retrofittest.service

import com.example.retrofittest.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val TOKEN = "***"

// 通常Retroﬁt的接口文件建议以具体的功能种类名开头，并以Service结尾
interface PlaceService {

    @GET("place?token=$TOKEN&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>

}