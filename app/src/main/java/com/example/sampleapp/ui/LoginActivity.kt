package com.example.sampleapp.ui
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleapp.databinding.ActivityLoginBinding
import com.example.sampleapp.ui.home.HomeActivity
import com.example.sampleapp.utils.onThrottledClick


class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        initView()
    }

    private fun initView() {
        loginBinding.isPasswordVisible = true
        loginBinding.signInButton.onThrottledClick {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        loginBinding.tvSignUpLabel.onThrottledClick {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        loginBinding.ivConfirmPasswordEye.setOnClickListener {
            loginBinding.isPasswordVisible = !loginBinding.isPasswordVisible!!
            if(loginBinding.isPasswordVisible!!){
                loginBinding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                loginBinding.etPassword.transformationMethod = null;
            }else{
                loginBinding.etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                loginBinding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance();
            }
        }
    }

}