package com.example.sampleapp.ui

import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ActivitySignUpBinding
import com.example.sampleapp.utils.onThrottledClick

class SignUpActivity : AppCompatActivity() {


    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.confirmPasswordVisible = true
        binding.passwordVisible = true
        binding.tvSignInLabel.onThrottledClick {
            finish()
        }

        binding.ivPasswordEye.onThrottledClick {
            binding.passwordVisible = !binding.passwordVisible!!
            if(binding.passwordVisible!!){
                binding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                binding.etPassword.transformationMethod = null;
            }else{
                binding.etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance();
                if(binding.etPassword.text!=null){
                    binding.etPassword.setSelection(binding.etPassword.text!!.length);
                }


            }
        }

        binding.ivConfirmPasswordEye.onThrottledClick {
            binding.confirmPasswordVisible = !binding.confirmPasswordVisible!!
            if(binding.confirmPasswordVisible!!){
                binding.etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                binding.etConfirmPassword.transformationMethod = null;
            }else{
                binding.etConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                binding.etConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance();
                if(binding.etConfirmPassword.text!=null){
                    binding.etConfirmPassword.setSelection(binding.etConfirmPassword.text!!.length);
                }
            }
        }
    }
}