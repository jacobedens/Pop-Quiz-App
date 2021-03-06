package com.revature.popquiz.model.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.revature.popquiz.model.api.services.QuizApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.LoggingEventListener
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Helper class for loading from a server
 *
 * Contains call functions for the api
 */
object RetrofitHelper {

    private val retrofit: Retrofit

    init {
        /**
         * Create a builder for Retrofit, including:
         *
         * Base URL of the API
         * Converter Factory to convert Kotlin to JSON
         * CallAdapter to include Coroutine functionality into loading
         */
        val builder = Retrofit.Builder()
            .baseUrl(NetConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        /**
         * Logging Interceptor:
         * Adds an interceptor to the OkHttp client and allows for logs to be created
         * during server connection
         */
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val listener = LoggingEventListener.Factory()

        /**
         * OkHttp client using the interceptor to add logging of timeout to server
         */
        val okHttpClient = OkHttpClient.Builder()
            .writeTimeout(0, TimeUnit.MILLISECONDS)
            .writeTimeout(30, TimeUnit.MILLISECONDS)
            .dns(DnsSelector())
            .eventListenerFactory(listener)
            .addInterceptor(loggingInterceptor).build()

        /**
         * Builds the retrofit object using the OkHttp client and builder
         */
        retrofit = builder.client(okHttpClient).build()
    }

    /**
     * Retrieves the QuizApiService for API use
     */
    fun getAllQuizzesServices(): QuizApiService {
        return retrofit.create(QuizApiService::class.java)
    }

}