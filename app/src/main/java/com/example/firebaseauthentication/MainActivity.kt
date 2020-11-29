package com.example.firebaseauthentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(
                account.text.toString(),
                password.text.toString()
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "登入失敗", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun register(view: View) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                account.text.toString(),
                password.text.toString()
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "註冊成功", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "註冊失敗", Toast.LENGTH_SHORT).show()
            }
        }
    }
}