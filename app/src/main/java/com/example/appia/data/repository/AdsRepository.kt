package com.example.appia.data.repository

import com.example.appia.data.network.AdResponse
import com.example.appia.data.network.AdService

class AdsRepository(private val adService: AdService) {

  suspend fun getAds(
    id: String,
    password: String,
    siteId: String,
    deviceId: String,
    sessionId: String,
    totalCampaignsRequested: String
  ): AdResponse{
    return adService.getAdsAsync(id, password, siteId, deviceId, sessionId, totalCampaignsRequested).await()
  }

  companion object {
    // For Singleton instantiation
    @Volatile
    private var instance: AdsRepository? = null

    fun getInstance(adService: AdService) =
      instance ?: synchronized(this) {
        instance ?: AdsRepository(adService).also { instance = it }
      }
  }

}