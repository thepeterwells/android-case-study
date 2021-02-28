package com.target.targetcasestudy.ui.deal.detail

import com.target.targetcasestudy.data.Deal

interface IDealDetailView {
    fun toggleProgressVisibility(visible: Boolean)
    fun bindDealData(deal: Deal)
}