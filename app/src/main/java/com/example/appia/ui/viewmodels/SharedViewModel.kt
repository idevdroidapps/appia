package com.example.appia.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appia.data.models.Campaign
import com.example.appia.data.repository.AdsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SharedViewModel(
  private val repository: AdsRepository
): ViewModel() {

  private var _ads = MutableLiveData<List<Campaign>>()
  val ads: LiveData<List<Campaign>> get() = _ads

  init {
    getAds("236", "OVUJ1DJN", "10777", "4230", "techtestsession", "2")
  }

  private fun getAds(
    id: String,
    password: String,
    siteId: String,
    deviceId: String,
    sessionId: String,
    totalCampaignsRequested: String
  ){
    viewModelScope.launch {
      var ads = emptyList<Campaign>()
      withContext(Dispatchers.IO){
        val response = repository.getAds(id, password, siteId, deviceId, sessionId, totalCampaignsRequested)
        ads = response.campaigns
      }
      _ads.value = ads
    }
  }

}