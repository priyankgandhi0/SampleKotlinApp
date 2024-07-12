package com.example.sampleapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleapp.databinding.ActivitySplashScreenBinding
import java.util.Timer
import java.util.TimerTask


class SplashScreen : AppCompatActivity() {


    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT))
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //(this.application as MyApplication).applicationComponent().inject(this)
        initView()
    }

    private fun initView(){
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
                finish()
            }
        }, 3000)
    }
}