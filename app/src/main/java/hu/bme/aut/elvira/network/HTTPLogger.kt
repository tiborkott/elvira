package hu.bme.aut.elvira.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object HTTPLogger {

        fun getLogger(): OkHttpClient {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            return client
        }
}