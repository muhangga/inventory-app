/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.sign.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.sign.login.LoginActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_daftar.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        }
    }
}
