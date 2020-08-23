package com.example.appia.data.injectors

import androidx.lifecycle.ViewModelProvider
import com.example.appia.data.network.AdService
import com.example.appia.data.network.AdsApi
import com.example.appia.data.repository.AdsRepository
import com.example.appia.ui.factories.SharedViewModelFactory

object Injection {

  /**
   * Creates an instance of [AdService]
   */
  private fun provideAdService(): AdService {
    return AdsApi.create()
  }

  /**
   * Creates an instance of [AdsRepository]
   */
  fun provideAdsRepository(): AdsRepository {
    return AdsRepository.getInstance(provideAdService())
  }

  /**
   * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
   * [ViewModel] objects.
   */
  fun provideSharedViewModelFactory(): ViewModelProvider.Factory {
    return SharedViewModelFactory(provideAdsRepository())
  }

}