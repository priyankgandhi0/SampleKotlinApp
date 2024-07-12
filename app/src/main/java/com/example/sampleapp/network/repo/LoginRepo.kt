package com.example.sampleapp.network.repo

import androidx.lifecycle.MutableLiveData
import com.example.sampleapp.model.ProductModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepo : BaseRepo() {

    fun getProducts(limit: Int, skip: Int): MutableLiveData<ProductModel>{
        val livedata: MutableLiveData<ProductModel> = MutableLiveData();
        GlobalScope.launch {
            try{
                val result = apiRequests.getProducts(limit, skip)
                result.body()?.let {
                    //livedata.value = it
                    livedata.postValue(it)
                    println(it)
                }
            }catch (e: Exception) {
                println(e)
            }
        }
        return livedata
    }

}

