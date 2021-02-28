package com.target.targetcasestudy.ui.deal

import com.target.targetcasestudy.data.Deal
import com.target.targetcasestudy.data.service.DealListEvent
import com.target.targetcasestudy.data.service.DealListService
import com.target.targetcasestudy.ui.custom.DealListItemListener
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class DealListPresenter @Inject constructor(private val service: DealListService) : DealListItemListener {

    private lateinit var view: IDealListView

    fun start(view: IDealListView) {
        this.view = view
        view.toggleProgressVisibility(true)
        service.getDealList()
    }

    fun onResume() {
        EventBus.getDefault().register(this)
    }

    fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    override fun onDealClicked(dealId: Int) {
        view.toDealDetail(dealId)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onEvent(event: DealListEvent) {
        EventBus.getDefault().removeStickyEvent(event::class)
        view.toggleProgressVisibility(false)
        if (event.isSuccess) {
            view.bindDealsData(event.data?.products ?: ArrayList())
        }
    }
}