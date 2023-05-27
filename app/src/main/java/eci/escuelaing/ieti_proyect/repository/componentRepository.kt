package eci.escuelaing.ieti_proyect.repository

import eci.escuelaing.ieti_proyect.network.ComponentService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object componentRepository {

    private const val baseUrl = "http://192.168.20.4:8080/"

    private val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()

    private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    fun create(): ComponentService {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        return retrofit.create(ComponentService::class.java)
    }


}