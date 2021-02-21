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
import android.widget.Toast
import com.google.firebase.database.*
import com.muhangga.inventory_app.utils.Preferences
import kotlinx.android.synthetic.main.activity_login.et_password
import kotlinx.android.synthetic.main.activity_login.et_username


class LoginActivity : AppCompatActivity() {

    lateinit var iUsername : String
    lateinit var iPassword : String
    lateinit var preferences : Preferences
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        preferences = Preferences(this)
        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        btn_login.setOnClickListener {
            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()

            if (iUsername.equals("")) {
                et_username.error = "Masukan Username anda!"
                et_username.requestFocus()
            }
            else if (iPassword.equals("")) {
                et_password.error = "Masukan Password anda!"
                et_password.requestFocus()
            }
            else {
                login(iUsername, iPassword)
            }
        }

        btn_daftar.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }

    private fun login(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var user = dataSnapshot.getValue(User::class.java)

                if (user == null) {
                    Toast.makeText(this@LoginActivity, "User Anda tidak ditemukan",
                        Toast.LENGTH_LONG).show()
                } else {

                    if (user.password.equals(iPassword)) {
                        preferences.setValues("nama", user.nama.toString())
                        preferences.setValues("username", user.username.toString())
                        preferences.setValues("status", "1")

                        var intent = Intent(this@LoginActivity, KategoriBarangActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@LoginActivity, "Password anda salah, silahkan coba lagi!",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@LoginActivity, databaseError.message,
                    Toast.LENGTH_LONG).show()
            }
        })

    }
}
