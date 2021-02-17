/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.sign.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.modules.kategori.KategoriBarangActivity
import com.muhangga.inventory_app.sign.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_daftar.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }

        btn_login.setOnClickListener {
            startActivity(Intent(this@LoginActivity, KategoriBarangActivity::class.java))
        }

    }
}
