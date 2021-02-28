package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.event.BaseEvent
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.greenrobot.eventbus.EventBus
import retrofit2.Call

open class BaseService<TBody>() {
   inline fun callAsync(crossinline call: () -> Call<TBody>, event: BaseEvent<TBody>) : Deferred<BaseEvent<TBody>> {
        return GlobalScope.async {
            event.response = call().execute()
            event.isSuccess = event.response.code() in 200..299
            if (!event.isSuccess) {
                event.errorMessage = event.response.errorBody()?.string() ?: "Network Error"
            }
            EventBus.getDefault().postSticky(event)
            event
        }
    }
}