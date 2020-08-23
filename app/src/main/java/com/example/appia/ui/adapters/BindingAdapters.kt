package com.example.appia.ui.adapters

import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.appia.R
import com.example.appia.data.models.Campaign

@BindingAdapter("listData")
fun bindEpisodesRecyclerView(
  recyclerView: RecyclerView,
  data: LiveData<List<Campaign>>?
) {
  data?.let {
    val adapter = recyclerView.adapter as CampaignListAdapter
    adapter.submitList(it.value)
  }
}

@BindingAdapter("campaignName")
fun TextView.setCampaignName(campaign: Campaign?) {
  campaign?.let {
    text = it.productName
  }
}

@BindingAdapter("campaignRating")
fun TextView.setCampaignRating(campaign: Campaign?) {
  campaign?.let {
    text = it.rating.toString()
  }
}

@BindingAdapter("campaignThumbnail")
fun ImageView.campaignThumbnail(thumbnailUrl: String?) {
  thumbnailUrl?.let { url ->
    val options = RequestOptions()
      .diskCacheStrategy(DiskCacheStrategy.NONE)
      .placeholder(ColorDrawable(ContextCompat.getColor(this.context, R.color.panel_background)))
      .fitCenter()
    try {
      Glide
        .with(this.context)
        .load(url)
        .apply(options)
        .into(this)
    } catch (e: Exception) {
      Log.e("Glide", "Thumbnail Failed in Glide")
    }
  }
}

