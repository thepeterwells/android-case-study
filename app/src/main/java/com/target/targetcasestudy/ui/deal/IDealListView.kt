package com.target.targetcasestudy.ui.deal

import com.target.targetcasestudy.data.Deal

interface IDealListView {
    fun bindDealsData(deals: List<Deal>)
    fun toDealDetail(dealId: Int)
    fun toggleProgressVisibility(visible: Boolean)
}