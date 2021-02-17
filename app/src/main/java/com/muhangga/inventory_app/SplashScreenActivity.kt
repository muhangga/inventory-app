package com.muhangga.inventory_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.muhangga.inventory_app.sign.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }, 5000)

    }
}
