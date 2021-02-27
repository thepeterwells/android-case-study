package com.target.targetcasestudy.ui.deal

import javax.inject.Inject

class DealListPresenter @Inject constructor() {
    fun start(view: IDealListView) {
        view.bindDealsData()
    }
}