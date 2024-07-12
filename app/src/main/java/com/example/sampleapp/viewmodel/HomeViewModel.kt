package com.example.sampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleapp.model.ProductModel
import com.example.sampleapp.network.repo.LoginRepo

class HomeViewModel : ViewModel() {

    fun getProducts() : MutableLiveData<ProductModel>  {
        return LoginRepo().getProducts()
    }

}