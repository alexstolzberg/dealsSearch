package com.target.targetcasestudy.ui.deallist

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.DealItem
import com.target.targetcasestudy.util.formatRegularPrice
import kotlinx.android.synthetic.main.deal_list_item.view.*
import java.lang.ref.WeakReference

/**
 * This class creates and binds rows in the deals list
 */
class DealItemAdapter : RecyclerView.Adapter<DealItemAdapter.DealItemViewHolder>() {

    private var deals: List<DealItem> = emptyList()

    private var itemClickedListener: WeakReference<DealItemClickedListener>? = null
    fun setItemClickedListener(listener: DealItemClickedListener) {
        this.itemClickedListener = WeakReference(listener)
    }

    fun setDeals(deals: List<DealItem>) {
        this.deals = deals
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.deal_list_item, parent, false)
        return DealItemViewHolder(view)
    }

    override fun getItemCount(): Int = deals.size

    override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
        val item = deals[position]
        viewHolder.bind(item)
    }

    inner class DealItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: DealItem) {
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .error(R.drawable.outline_broken_image_black_48)
                .placeholder(R.drawable.outline_sync_black_48)
                .centerCrop()
                .into(itemView.dealImage)

            itemView.dealTitle.text = item.title
            itemView.salePrice.text =
                item.salePrice?.displayString ?: item.regularPrice.displayString
            itemView.regularPrice.apply {
                text = formatRegularPrice(itemView.context, item.regularPrice.displayString)
                visibility = if (item.salePrice != null) VISIBLE else GONE
            }
            itemView.aisle.text = item.aisle
            itemView.dealItemContainer.setOnClickListener {
                itemClickedListener?.get()?.onDealClicked(item)
            }
        }
    }
}

interface DealItemClickedListener {
    fun onDealClicked(dealItem: DealItem)
}