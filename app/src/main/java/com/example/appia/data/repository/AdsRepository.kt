package com.example.appia.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.appia.data.models.Campaign
import com.example.appia.data.network.AdService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AdsRepository(private val adService: AdService) {

  var campaigns = MutableLiveData<List<Campaign>>()

  suspend fun getAds(
    id: String,
    password: String,
    siteId: String,
    deviceId: String,
    sessionId: String,
    totalCampaignsRequested: String
  ) {
    GlobalScope.launch(Dispatchers.Main) {
      var campaignList = emptyList<Campaign>()
      withContext(Dispatchers.IO){
        val response =
          adService.getAds(id, password, siteId, deviceId, sessionId, totalCampaignsRequested)
        campaignList = response.campaigns
      }
      campaigns.value = campaignList
    }
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