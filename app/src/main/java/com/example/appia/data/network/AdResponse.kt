package com.example.appia.data.network

import android.os.Parcelable
import com.example.appia.data.models.Campaign
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AdResponse(
  @field:SerializedName("campaigns") val campaigns: List<Campaign>,
  @field:SerializedName("errorMessage") val errorMessage: String,
  @field:SerializedName("responseTime") val responseTime: String,
  @field:SerializedName("serverId") val serverId: String,
  @field:SerializedName("totalCampaignsRequested") val totalCampaignsRequested: Int,
  @field:SerializedName("version") val version: String
) : Parcelable