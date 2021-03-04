package com.target.targetcasestudy.data.event

import retrofit2.Response

open class BaseEvent<TBody> {
    open lateinit var response: Response<TBody>
    val data: TBody? get() = response.body()
    var isSuccess: Boolean = false
    var errorMessage: String? = null
    var cancelled: Boolean = false
}