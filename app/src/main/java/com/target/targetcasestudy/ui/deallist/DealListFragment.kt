package com.target.targetcasestudy.ui.deallist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration

import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.DealItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_deal_list.*

/**
 * Displays a list of deals in a scrolling list
 */
@AndroidEntryPoint
class DealListFragment : Fragment(), DealItemClickedListener {

    private val dealListViewModel: DealListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_deal_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DealItemAdapter()
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
        adapter.setItemClickedListener(this)

        dealListViewModel.getDeals()
        dealListViewModel.deals.observe(viewLifecycleOwner, { adapter.setDeals(it) })
    }

    override fun onDealClicked(dealItem: DealItem) {
        findNavController().navigate(
            DealListFragmentDirections.actionDealListFragmentToDealItemFragment(
                dealItem
            )
        )
    }
}
