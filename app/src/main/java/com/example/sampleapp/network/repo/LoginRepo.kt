package com.example.sampleapp.network.repo

import androidx.lifecycle.MutableLiveData
import com.example.sampleapp.model.ProductModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginRepo : BaseRepo() {

    fun getProducts() : MutableLiveData<ProductModel>{
        val livedata: MutableLiveData<ProductModel> = MutableLiveData();
        GlobalScope.launch {
            try{
                val result = apiRequests.getProducts(limit = 50, skip = 20)
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

