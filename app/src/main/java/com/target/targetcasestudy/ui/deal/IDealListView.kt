package com.target.targetcasestudy.ui.deal

import com.target.targetcasestudy.data.Deal

interface IDealListView {
    fun bindDealsData(deals: List<Deal>)
    fun toggleProgressVisibility(visible: Boolean)
}