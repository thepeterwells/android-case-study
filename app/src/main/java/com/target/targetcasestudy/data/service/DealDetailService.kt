package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.Deal
import com.target.targetcasestudy.data.event.BaseEvent
import com.target.targetcasestudy.data.response.DealListResponse
import javax.inject.Inject

class DealDetailService @Inject constructor(private val apiService: ApiService) : BaseService<Deal>() {
    fun getDealDetails(dealId: Int) {
        callAsync({ apiService.getDealDetails(dealId) }, DealDetailEvent())
    }
}

class DealDetailEvent: BaseEvent<Deal>()