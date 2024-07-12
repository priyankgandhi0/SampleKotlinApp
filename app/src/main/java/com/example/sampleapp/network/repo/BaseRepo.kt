package com.example.sampleapp.network.repo

import com.example.sampleapp.network.network_utils.ApiInterface
import com.example.sampleapp.network.network_utils.RetrofitHelper

open class BaseRepo {
    val apiRequests: ApiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
}