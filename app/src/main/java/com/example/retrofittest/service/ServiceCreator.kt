package com.example.retrofittest.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/v2/"

//    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // Reflection

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) // 用于指定所有Retroﬁt请求的根路径
        .addConverterFactory(MoshiConverterFactory.create(/*moshi*/)) // 用于指定Retroﬁt在解析数据时所使用的转换库，这里指定成MoshiConverterFactory
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    // 泛型实化
    inline fun <reified T> create(): T = create(T::class.java)

}