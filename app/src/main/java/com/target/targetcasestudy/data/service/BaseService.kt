package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.event.BaseEvent
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.greenrobot.eventbus.EventBus
import retrofit2.Call

open class BaseService<TBody>() {

   protected var call: Call<TBody>? = null

   protected inline fun callAsync(crossinline call: () -> Call<TBody>, event: BaseEvent<TBody>) : Deferred<BaseEvent<TBody>> {
       this.call = call()
        return GlobalScope.async {
            event.response = this@BaseService.call!!.execute()
            if (this@BaseService.call?.isCanceled != true) {
                event.isSuccess = event.response.code() in 200..299
                if (!event.isSuccess) {
                    event.errorMessage = event.response.errorBody()?.string() ?: "Network Error"
                }
            } else {
                event.cancelled = true
            }
            this@BaseService.call = null
            EventBus.getDefault().postSticky(event)
            event
        }
    }

    fun cancelCall() {
        call?.cancel()
    }
}