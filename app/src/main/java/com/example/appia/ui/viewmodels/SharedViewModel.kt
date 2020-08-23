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

  private var _campaigns = MutableLiveData<List<Campaign>>()
  val campaigns: LiveData<List<Campaign>> get() = _campaigns

  private var _navToSelectedCampaign = MutableLiveData<Campaign>()
  val navToSelectedCampaign: LiveData<Campaign> get() = _navToSelectedCampaign

  init {
    getAds("236", "OVUJ1DJN", "10777", "4230", "techtestsession", "15")
  }

  fun displayCampaignDetails(campaign: Campaign){
    _navToSelectedCampaign.value = campaign
  }

  fun displayCampaignDetailsComplete(){
    _navToSelectedCampaign.value = null
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
      _campaigns.value = ads
    }
  }

}