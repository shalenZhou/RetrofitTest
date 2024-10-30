package com.example.retrofittest.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "http://10.0.2.2/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) // 用于指定所有Retroﬁt请求的根路径
        .addConverterFactory(GsonConverterFactory.create()) // 用于指定Retroﬁt在解析数据时所使用的转换库，这里指定成GsonConverterFactory
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    // 泛型实化
    inline fun <reified T> create(): T = create(T::class.java)
}