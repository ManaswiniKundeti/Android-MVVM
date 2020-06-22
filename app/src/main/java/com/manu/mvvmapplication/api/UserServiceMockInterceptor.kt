package com.manu.mvvmapplication.api

import okhttp3.*
import java.util.*

class UserServiceMockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
            .newBuilder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(userResponseString)
            .body(
                ResponseBody.create(
                    MediaType.parse("application/json"),
                    userResponseString.toByteArray()))
            .addHeader("content-type", "application/json")
            .build()
    }

}

val userResponseString = """
{
	"id": "12345",
	"name": "Manaswini Kundeti",
	"email": "kundeti.manawini@gmail.com"
}
"""