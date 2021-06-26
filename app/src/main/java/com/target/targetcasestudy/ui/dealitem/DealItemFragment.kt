package com.target.targetcasestudy.ui.dealitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.DealItem
import com.target.targetcasestudy.util.formatRegularPrice
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_deal_item.*
import timber.log.Timber
import java.lang.IllegalArgumentException

/**
 * Details page to show information about a deal
 */
@AndroidEntryPoint
class DealItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_deal_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the deal from the args
        val dealItem =
            arguments?.getParcelable<DealItem>(ARG_DEAL_ITEM) ?: throw IllegalArgumentException()

        Glide.with(view.context)
            .load(dealItem.imageUrl)
            .error(R.drawable.outline_broken_image_black_48)
            .placeholder(R.drawable.outline_sync_black_48)
            .centerCrop()
            .into(productImage)

        productTitle.text = dealItem.title
        productPrice.text =
            dealItem.salePrice?.displayString ?: dealItem.regularPrice.displayString

        productRegularPrice.visibility = if (dealItem.salePrice != null) VISIBLE else GONE
        productRegularPrice.text =
            formatRegularPrice(requireContext(), dealItem.regularPrice.displayString)

        productDescription.text = dealItem.description

        addToListButton.setOnClickListener {
            Timber.i("Add To List Clicked")
        }

        addToCartButton.setOnClickListener {
            Timber.i("Add To Cart Clicked")
        }
    }

    companion object {
        private const val ARG_DEAL_ITEM = "dealItem"
    }
}
