package com.example.appia.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.appia.data.models.Campaign
import com.example.appia.ui.viewholders.CampaignViewHolder
import com.example.appia.ui.viewmodels.SharedViewModel

class CampaignListAdapter(private val viewModel: SharedViewModel) :
  ListAdapter<Campaign, CampaignViewHolder>(DiffCallback) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignViewHolder {
    return CampaignViewHolder.from(parent)
  }

  override fun onBindViewHolder(holder: CampaignViewHolder, position: Int) {
    getItem(position)?.let {
      holder.bind(it, viewModel)
    }
  }

  companion object DiffCallback : DiffUtil.ItemCallback<Campaign>() {
    override fun areItemsTheSame(
      oldItem: Campaign,
      newItem: Campaign
    ): Boolean {
      return oldItem === newItem
    }

    override fun areContentsTheSame(
      oldItem: Campaign,
      newItem: Campaign
    ): Boolean {
      return oldItem.campaignId == newItem.campaignId
    }
  }

}