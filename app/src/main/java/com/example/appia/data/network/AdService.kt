package com.example.appia.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AdService{

  @Headers("Accept: application/json")
  @GET("getAds")
  fun getAdsAsync(
    @Query("id") id: String,
    @Query("password") password: String,
    @Query("siteId") siteId: String,
    @Query("deviceId") deviceId: String,
    @Query("sessionId") sessionId: String,
    @Query("totalCampaignsRequested") totalCampaignsRequested: String
  ): Deferred<AdResponse>

}

object AdsApi {

  private const val BASE_URL = "http://ads.appia.com"

  fun create(): AdService {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BASIC

    val client = OkHttpClient.Builder()
      .addInterceptor(logger)
      .build()
    return Retrofit.Builder()
      .baseUrl(BASE_URL.toHttpUrl())
      .client(client)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
      .create(AdService::class.java)
  }

}