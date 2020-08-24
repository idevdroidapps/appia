package com.example.appia.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Campaign(
  @field:SerializedName("advertiserDomainUrl") val advertiserDomainUrl: String,
  @field:SerializedName("apks") val apks: String,
  @field:SerializedName("appId")  val appId: String,
  @field:SerializedName("appPrivacyPolicyUrl") val appPrivacyPolicyUrl: String,
  @field:SerializedName("averageRatingImageURL") val averageRatingImageURL: String,
  @field:SerializedName("bidRate") val bidRate: Double,
  @field:SerializedName("billingTypeId") val billingTypeId: Int,
  @field:SerializedName("callToAction") val callToAction: String,
  @field:SerializedName("campaignDisplayOrder") val campaignDisplayOrder: Int,
  @field:SerializedName("campaignId") val campaignId: Int,
  @field:SerializedName("campaignTypeId") val campaignTypeId: Int,
  @field:SerializedName("carrier") val carrier: String,
  @field:SerializedName("categoryName") val categoryName: String,
  @field:SerializedName("clickProxyURL") val clickProxyURL: String,
  @field:SerializedName("creativeId") val creativeId: Int,
  @field:SerializedName("developerName") val developerName: String,
  @field:SerializedName("dtPrivacyPolicyUrl") val dtPrivacyPolicyUrl: String,
  @field:SerializedName("externalMetadata") val externalMetadata: String,
  @field:SerializedName("googlePlayAppStoreUrl") val googlePlayAppStoreUrl: String,
  @field:SerializedName("homeScreen") val homeScreen: Boolean,
  @field:SerializedName("impressionTrackingURL") val impressionTrackingURL: String,
  @field:SerializedName("isRandomPick") val isRandomPick: Boolean,
  @field:SerializedName("longDescription") val longDescription: String,
  @field:SerializedName("maxOSVersion") val maxOSVersion: String,
  @field:SerializedName("minOSVersion") val minOSVersion: String,
  @field:SerializedName("mmpPartner") val mmpPartner: String,
  @field:SerializedName("numberOfDownloads") val numberOfDownloads: String,
  @field:SerializedName("numberOfRatings") val numberOfRatings: String,
  @field:SerializedName("postInstallActions") val postInstallActions: List<String>,
  @field:SerializedName("productDescription") val productDescription: String,
  @field:SerializedName("productId") val productId: Int,
  @field:SerializedName("productImage") val productImage: String,
  @field:SerializedName("productName") val productName: String,
  @field:SerializedName("productThumbnail") val productThumbnail: String,
  @field:SerializedName("rating") val rating: Double,
  @field:SerializedName("screenshots") val screenshots: String,
  @field:SerializedName("stiEnabled") val stiEnabled: Boolean,
  @field:SerializedName("tstiEligible") val tstiEligible: Boolean
) : Parcelable