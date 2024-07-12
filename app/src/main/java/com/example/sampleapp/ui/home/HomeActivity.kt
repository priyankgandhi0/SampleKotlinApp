package com.example.sampleapp.ui.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ActivityHomeBinding
import com.example.sampleapp.model.ProductModel
import com.example.sampleapp.ui.LoginActivity
import com.example.sampleapp.viewmodel.HomeViewModel


class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel



    lateinit var productAdapter: ProductAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeBinding.viewModel = viewModel
        homeBinding.setLifecycleOwner(this)

        viewModel.getProducts();
        viewModel.productModelLiveData.observe(this) {
            productAdapter.addProducts(it.products)
        }
        linearLayoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(productList = arrayListOf(), context = this)
        homeBinding.rvProducts.layoutManager = linearLayoutManager
        homeBinding.rvProducts.adapter = productAdapter;
        initViews()
    }


    private fun initViews() {
        homeBinding.ivLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        homeBinding.rvProducts.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = linearLayoutManager.childCount
                val pastVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                val total = productAdapter.itemCount
                if (!viewModel.isLoading.value!!) {
                    if ((visibleItemCount + pastVisibleItem) >= total) {
                        viewModel.page += 1
                        viewModel.getProducts()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }


}

