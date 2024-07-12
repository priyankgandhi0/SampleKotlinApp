package com.example.sampleapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.sampleapp.databinding.ActivityHomeBinding
import com.example.sampleapp.model.ProductModel
import com.example.sampleapp.ui.LoginActivity
import com.example.sampleapp.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    var productModelLiveData : MutableLiveData<ProductModel> = MutableLiveData()

    lateinit  var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        productModelLiveData = viewModel.getProducts();
        productModelLiveData.observe(this) {
           it.products;
            productAdapter.addProducts(it.products)
        }
        productAdapter = ProductAdapter(productList = arrayListOf(), context = this)
        homeBinding.rvProducts.adapter = productAdapter;
        initViews()
    }

    private fun initViews() {
        homeBinding.ivLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}