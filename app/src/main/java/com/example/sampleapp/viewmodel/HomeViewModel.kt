package com.example.sampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleapp.model.ProductModel
import com.example.sampleapp.network.repo.LoginRepo

class HomeViewModel : ViewModel() {


    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var bottomLoading: MutableLiveData<Boolean> = MutableLiveData()


    var limit = 20;
    var page = 0;

    var productModelLiveData: MutableLiveData<ProductModel> = MutableLiveData()


    fun getProducts(){
        if(page==0) isLoading.postValue(true)
        if(page!=0)bottomLoading.postValue(true)
         LoginRepo().getProducts(limit,page*limit).observeForever {
             isLoading.postValue(false)
             bottomLoading.postValue(false)
             productModelLiveData.postValue(it)
        }
    }

}