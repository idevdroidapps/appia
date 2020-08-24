package com.example.appia.ui.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appia.data.repository.AdsRepository
import com.example.appia.ui.viewmodels.SharedViewModel

class SharedViewModelFactory(
  private val adsRepository: AdsRepository
) : ViewModelProvider.Factory {
  @Suppress("unchecked_cast")
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
      return SharedViewModel(adsRepository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}