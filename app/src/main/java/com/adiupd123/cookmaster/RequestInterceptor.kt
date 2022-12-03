package com.adiupd123.cookmaster

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.e(TAG,"Outgoing request to ${request.url}")
        return chain.proceed(request)
    }
}