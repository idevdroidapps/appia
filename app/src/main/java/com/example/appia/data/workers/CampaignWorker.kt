package com.example.appia.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.appia.R
import com.example.appia.data.injectors.Injection

class CampaignWorker(private val context: Context, workerParameters: WorkerParameters) :
  CoroutineWorker(context, workerParameters) {

  override suspend fun doWork(): Result {
    return try {
      val repository = Injection.provideAdsRepository()
      repository.getAds(
        context.getString(R.string.appia_api_id),
        context.getString(R.string.appia_api_password),
        "10777",
        "4230",
        "techtestsession",
        "15",
        "Campbell"
      )
      Result.success()
    } catch (e: Exception) {
      e.printStackTrace()
      Result.failure()
    }
  }
}