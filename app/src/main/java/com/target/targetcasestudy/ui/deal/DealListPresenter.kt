package com.target.targetcasestudy.ui.deal

import com.target.targetcasestudy.data.service.DealListEvent
import com.target.targetcasestudy.data.service.DealListService
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class DealListPresenter @Inject constructor(private val service: DealListService) {

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

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onEvent(event: DealListEvent) {
        EventBus.getDefault().removeStickyEvent(event::class)
        view.toggleProgressVisibility(false)
        if (event.isSuccess) {
            view.bindDealsData(event.data?.products ?: ArrayList())
        }
    }
}