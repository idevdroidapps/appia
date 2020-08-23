package com.example.appia.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.appia.R
import com.example.appia.data.injectors.Injection
import com.example.appia.databinding.ActivityMainBinding
import com.example.appia.ui.viewmodels.SharedViewModel

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // ViewModel
    val viewModel = ViewModelProvider(
      this@MainActivity,
      Injection.provideSharedViewModelFactory()
    ).get(SharedViewModel::class.java)

    // Binding
    val binding: ActivityMainBinding = DataBindingUtil
      .setContentView(this@MainActivity, R.layout.activity_main)

    binding.lifecycleOwner = this
  }
}