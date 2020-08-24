package com.example.appia.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appia.data.models.Campaign
import com.example.appia.databinding.ItemCampaignBinding
import com.example.appia.ui.viewmodels.SharedViewModel

class CampaignViewHolder(private val binding: ItemCampaignBinding) :
  RecyclerView.ViewHolder(binding.root) {

  fun bind(
    item: Campaign,
    viewModel: SharedViewModel
  ) {
    binding.campaign = item
    binding.viewModel = viewModel
    binding.executePendingBindings()
  }

  companion object {
    fun from(parent: ViewGroup): CampaignViewHolder {
      val layoutInflater =
        LayoutInflater.from(parent.context)
      val binding = ItemCampaignBinding.inflate(layoutInflater, parent, false)
      return CampaignViewHolder(binding)
    }
  }

}