package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.Deal
import com.target.targetcasestudy.data.response.DealListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v1/deals")
    fun getDeals() : Call<DealListResponse>

    @GET("v1/deals/{id}")
    fun getDealDetails(@Path("id") dealId: Int) : Call<Deal>
}