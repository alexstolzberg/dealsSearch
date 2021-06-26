package com.target.targetcasestudy.util

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import com.target.targetcasestudy.R

/**
 * Utility function for formatting the regular price with a strikethrough
 */
fun formatRegularPrice(context: Context, originalPrice: String): SpannableStringBuilder {
    val priceString = context.resources.getString(R.string.regular_price, originalPrice)
    val priceSpannable = SpannableStringBuilder(priceString)
    val indexOfPrice = priceString.indexOf('$', ignoreCase = true)
    priceSpannable.setSpan(
        StrikethroughSpan(),
        indexOfPrice,
        priceString.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return priceSpannable
}