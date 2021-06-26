package com.target.targetcasestudy.ui.deallist

import androidx.lifecycle.*
import com.target.targetcasestudy.api.DealsRepository
import com.target.targetcasestudy.api.Success
import com.target.targetcasestudy.data.DealItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Communicates with the DealsRepository to load deals and pass them to the view
 */
@HiltViewModel
class DealListViewModel @Inject constructor(
    private val dealsRepository: DealsRepository
) : ViewModel() {

    private val _deals = MutableLiveData<List<DealItem>>()
    val deals: LiveData<List<DealItem>>
        get() = _deals

    fun getDeals() {
        viewModelScope.launch {
            when (val deals = dealsRepository.loadDeals()) {
                is Success -> _deals.value = deals.data
                else -> _deals.value = emptyList()
            }
        }
    }
}