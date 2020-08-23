package com.example.appia.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.appia.R
import com.example.appia.data.injectors.Injection
import com.example.appia.data.workers.CampaignWorker
import com.example.appia.ui.viewmodels.SharedViewModel

class MainActivity : AppCompatActivity() {

  var viewModel: SharedViewModel? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // init shared viewModel
    viewModel = ViewModelProvider(
      this@MainActivity,
      Injection.provideSharedViewModelFactory()
    ).get(SharedViewModel::class.java)

    // use workManager to make api request
    val constraints = Constraints.Builder()
      .setRequiredNetworkType(NetworkType.CONNECTED)
      .build()
    val oneTimeWorkRequest = OneTimeWorkRequestBuilder<CampaignWorker>()
      .setConstraints(constraints)
      .build()
    WorkManager.getInstance(this@MainActivity).enqueue(oneTimeWorkRequest)

  }
}