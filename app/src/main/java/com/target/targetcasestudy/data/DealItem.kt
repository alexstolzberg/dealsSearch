package com.target.targetcasestudy.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Model object returned by the DealsService and used throughout the app
 */
@Parcelize
data class DealItem(
    val id: Int,
    val title: String,
    val aisle: String,
    val description: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("regular_price") val regularPrice: PriceInfo,
    @SerializedName("sale_price") val salePrice: PriceInfo?
) : Parcelable

@Parcelize
data class PriceInfo(
    @SerializedName("amount_in_cents") val centsAmount: Int,
    @SerializedName("currency_symbol") val currencySymbol: String,
    @SerializedName("display_string") val displayString: String
) :Parcelable