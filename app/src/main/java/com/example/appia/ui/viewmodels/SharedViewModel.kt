package com.example.appia.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appia.data.models.Campaign
import com.example.appia.data.repository.AdsRepository

class SharedViewModel(
  repository: AdsRepository
) : ViewModel() {

  val campaigns: LiveData<List<Campaign>> = repository.campaigns

  var selectedCampaign: Campaign? = null

  private var _navToSelectedCampaign = MutableLiveData<Campaign>()
  val navToSelectedCampaign: LiveData<Campaign> get() = _navToSelectedCampaign

  private var _navToWebUrl = MutableLiveData<String>()
  val navToWebUrl: LiveData<String> get() = _navToWebUrl

  fun displayCampaignDetails(campaign: Campaign) {
    selectedCampaign = campaign
    _navToSelectedCampaign.value = campaign
  }

  fun displayCampaignDetailsComplete() {
    _navToSelectedCampaign.value = null
  }

  fun navToWebUrl(url: String){
    _navToWebUrl.value = url
  }

  fun navToWebUrlComplete(){
    _navToWebUrl.value = null
  }

}