package com.example.appia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appia.R
import com.example.appia.databinding.FragmentListBinding
import com.example.appia.ui.adapters.CampaignListAdapter
import com.example.appia.ui.viewmodels.SharedViewModel

class ListFragment : Fragment() {

  private val viewModel: SharedViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    // init binding
    val binding: FragmentListBinding =
      DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
    binding.lifecycleOwner = this
    binding.viewModel = viewModel

    // init list adapter
    val adapter = CampaignListAdapter(viewModel)
    binding.recyclerViewEpisodes.adapter = adapter

    // display campaign details upon item click
    viewModel.navToSelectedCampaign.observe(viewLifecycleOwner, { campaign ->
      campaign?.let {
        Toast.makeText(context, it.productName, Toast.LENGTH_SHORT).show()
        viewModel.displayCampaignDetailsComplete()
      }
    })

    return binding.root

  }
}