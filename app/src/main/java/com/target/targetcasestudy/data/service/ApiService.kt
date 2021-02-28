package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.response.DealListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v1/deals")
    fun getDeals() : Call<DealListResponse>
}