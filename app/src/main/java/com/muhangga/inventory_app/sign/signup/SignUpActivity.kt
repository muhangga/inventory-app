/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.sign.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.modules.makanan.MakananActivity
import com.muhangga.inventory_app.sign.login.LoginActivity
import com.muhangga.inventory_app.sign.login.User
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var iNama     : String
    private lateinit var iUsername : String
    private lateinit var iPassword : String
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        btn_daftar.setOnClickListener {

            iNama = et_namalengkap.text.toString()
            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()

            if (iNama.equals("")) {
                et_namalengkap.error = "Silahkan isi nama lengkap anda"
                et_namalengkap.requestFocus()
            }
            else if (iUsername.equals("")) {
                et_username.error = "Silahkan isi username anda"
                et_username.requestFocus()
            }
            else if (iPassword.equals("")) {
                et_password.error = "Silahkan isi password anda"
                et_password.requestFocus()
            }
            else {
                buatAkun(iNama, iUsername, iPassword)
            }
        }

        tv_punya_akun.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun buatAkun(iNama: String, iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignUpActivity, databaseError.message,
                    Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user = User()

                user.nama = iNama
                user.username = iUsername.trim()
                user.password = iPassword

                mDatabase.child(iUsername).setValue(user)
                    .addOnCompleteListener {
                        Toast.makeText(this@SignUpActivity, "Akun User berhasil ditambahkan!", Toast.LENGTH_LONG).show()

                        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                    }
                    .addOnFailureListener {
                        Toast.makeText(this@SignUpActivity, "Akun User gagal ditambahkan", Toast.LENGTH_LONG).show()
                    }
            }

        })
    }
}
