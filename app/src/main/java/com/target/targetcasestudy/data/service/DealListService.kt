package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.event.BaseEvent
import com.target.targetcasestudy.data.response.DealListResponse
import javax.inject.Inject

class DealListService @Inject constructor(private val apiService: ApiService) : BaseService<DealListResponse>() {
    fun getDealList() {
        callAsync({ apiService.getDeals() }, DealListEvent())
    }
}

class DealListEvent: BaseEvent<DealListResponse>()