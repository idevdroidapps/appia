package com.example.appia.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.appia.data.injectors.Injection

class CampaignWorker(context: Context, workerParameters: WorkerParameters) :
  CoroutineWorker(context, workerParameters) {

  override suspend fun doWork(): Result {
    return try {
      val repository = Injection.provideAdsRepository()
      repository.getAds(
        "236",
        "OVUJ1DJN",
        "10777",
        "4230",
        "techtestsession",
        "15"
      )
      Result.success()
    } catch (e: Exception) {
      e.printStackTrace()
      Result.failure()
    }
  }
}