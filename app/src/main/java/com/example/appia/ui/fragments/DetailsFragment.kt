package com.example.appia.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.appia.R
import com.example.appia.data.utils.CustomTabHelper
import com.example.appia.databinding.FragmentDetailsBinding
import com.example.appia.ui.viewmodels.SharedViewModel

class DetailsFragment : Fragment() {

  private val viewModel: SharedViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val binding: FragmentDetailsBinding =
      DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
    binding.lifecycleOwner = this
    binding.viewModel = viewModel

    // handles Call To Action button
    viewModel.navToWebUrl.observe(viewLifecycleOwner, { url ->
      url?.let { ctaUrl ->
        context?.let {
          // check for package that can handle custom tabs
          val packageName = CustomTabHelper().getPackageNameToUse(it, ctaUrl)
          if(packageName == null){
            // use default browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(ctaUrl))
            startActivity(browserIntent)
          } else {
            // use cct
            val customTabBuilder = CustomTabsIntent.Builder()
            val customTabIntent = customTabBuilder.build()
            customTabIntent.intent.setPackage(packageName)
            customTabIntent.launchUrl(it, Uri.parse(url))
          }

        }
        viewModel.navToWebUrlComplete()
      }
    })

    return binding.root
  }
}