package com.example.appia.ui.adapters

import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.Button
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
fun TextView.campaignName(campaign: Campaign?) {
  campaign?.let {
    text = it.productName
  }
}

@BindingAdapter("campaignRating")
fun ImageView.campaignRating(ratingUrl: String?) {
  ratingUrl?.let { url ->
    val options = RequestOptions()
      .override(100, 50)
      .diskCacheStrategy(DiskCacheStrategy.NONE)
      .placeholder(ColorDrawable(ContextCompat.getColor(this.context, android.R.color.white)))
      .fitCenter()
    try {
      Glide
        .with(this.context)
        .load(url)
        .apply(options)
        .into(this)
    } catch (e: Exception) {
      Log.e("Glide", "Rating Image Failed in Glide")
    }
  }
}

@BindingAdapter("campaignThumbnail")
fun ImageView.campaignThumbnail(thumbnailUrl: String?) {
  thumbnailUrl?.let { url ->
    val options = RequestOptions()
      .override(280, 280)
      .diskCacheStrategy(DiskCacheStrategy.NONE)
      .placeholder(ColorDrawable(ContextCompat.getColor(this.context, android.R.color.white)))
      .fitCenter()
    try {
      Glide
        .with(this.context)
        .load(url)
        .apply(options)
        .into(this)
    } catch (e: Exception) {
      Log.e("Glide", "Thumbnail Image Failed in Glide")
    }
  }
}

@BindingAdapter("campaignCta")
fun Button.campaignCta(campaign: Campaign?){
  campaign?.let {
    text = it.callToAction
  }
}

@BindingAdapter("campaignNumOfRatings")
fun TextView.campaignNumOfRatings(campaign: Campaign?){
  campaign?.let {
    text = it.numberOfRatings
  }
}

@BindingAdapter("campaignNumOfDownloads")
fun TextView.campaignNumOfDownloads(campaign: Campaign?){
  campaign?.let {
    val msg = "Downloaded: ${it.numberOfDownloads}"
    text = msg
  }
}

@BindingAdapter("campaignCategory")
fun TextView.campaignCategory(campaign: Campaign?){
  campaign?.let {
    val msg = "Category: ${it.categoryName}"
    text = msg
  }
}

@BindingAdapter("campaignDescription")
fun TextView.campaignDescription(campaign: Campaign?){
  campaign?.let {
    text = it.productDescription
  }
}



