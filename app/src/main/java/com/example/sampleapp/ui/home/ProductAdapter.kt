package com.example.sampleapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ProductLayoutBinding
import com.example.sampleapp.model.Product
import com.example.sampleapp.model.ProductModel


class ProductAdapter(var productList: ArrayList<Product>, var context: Context) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var  binding = ProductLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        productList[position].let {
           holder.binding.tvName.text = it.title
           holder.binding.descText.text = it.description
            Glide.with(this.context)
                .load(it.thumbnail)
                .placeholder(R.drawable.dish)
                .apply(RequestOptions.circleCropTransform())
                .skipMemoryCache(false)
                .into(holder.binding.ivUserImage)
        }
    }

    fun addProducts(products: List<Product>) {
        productList.clear()
        productList.addAll(products)
        notifyDataSetChanged()
    }

    inner class ViewHolder(var binding: ProductLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}