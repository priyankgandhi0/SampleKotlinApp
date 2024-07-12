package com.example.sampleapp.network.network_utils

sealed class AppResult<out R> {
    data class Success<out T>(val data: T) : AppResult<T>()
    data class Error(val exception: Exception) : AppResult<Nothing>()
}