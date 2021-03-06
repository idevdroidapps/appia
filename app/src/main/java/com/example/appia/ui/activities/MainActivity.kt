package com.example.appia.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    // check if user(developer) did not provide a secure.properties file as instructed in README.md
    if (getString(R.string.appia_api_id).isBlank() || getString(R.string.appia_api_password).isBlank()) {
      Toast.makeText(
        this@MainActivity,
        "Provide proper appia id and password. Check project README for instructions.",
        Toast.LENGTH_LONG
      ).show()
    } else {
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
}