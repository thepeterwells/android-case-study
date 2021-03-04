package com.target.targetcasestudy.ui.deal.detail

import com.target.targetcasestudy.data.service.DealDetailEvent
import com.target.targetcasestudy.data.service.DealDetailService
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class DealDetailPresenter @Inject constructor(private val service: DealDetailService) {

    private lateinit var view: IDealDetailView

    fun start(view: IDealDetailView, dealId: Int) {
        this.view = view
        view.toggleProgressVisibility(true)
        service.getDealDetails(dealId)
    }

    fun onResume() {
        EventBus.getDefault().register(this)
    }

    fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onEvent(event: DealDetailEvent) {
        EventBus.getDefault().removeStickyEvent(event::class.java)
        view.toggleProgressVisibility(false)
        if (event.isSuccess && event.data != null) {
            view.bindDealData(event.data!!)
        }
    }

}