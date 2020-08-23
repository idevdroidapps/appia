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

  private var _navToSelectedCampaign = MutableLiveData<Campaign>()
  val navToSelectedCampaign: LiveData<Campaign> get() = _navToSelectedCampaign

  fun displayCampaignDetails(campaign: Campaign) {
    _navToSelectedCampaign.value = campaign
  }

  fun displayCampaignDetailsComplete() {
    _navToSelectedCampaign.value = null
  }

}