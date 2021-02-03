package com.example.jokerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        init()
    }
    private fun init(){
        auth = Firebase.auth
        loginButton.setOnClickListener {
            login()
        }
        registerButton.setOnClickListener {
            register()
        }
    }

    //ავტორიზაცია
    private fun login(){
        val email = loginEmail.text.toString()
        val password = loginPassword.text.toString()
        if(email.isNotEmpty() && password.isNotEmpty()){

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Log In", "signInWithEmail:success")
                        val user = auth.currentUser
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Log In", "signInWithEmail:failure", task.exception)
                        Toast.makeText(this, "ავტორიზაცია ვერ მოხერხდა", Toast.LENGTH_LONG).show()
                    }
                }

        }else{
            Toast.makeText(this, "შეიყვანეთ იმეილი და პაროლი ავტორიზაციის ველებში", Toast.LENGTH_LONG).show()
        }
    }

    //რეგისტრაცია
    private fun register(){
        val email = registerEmail.text.toString()
        val password = registerPassword.text.toString()
        if(email.isNotEmpty() && password.isNotEmpty()){

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Register", "createUserWithEmail:success")
                        val user = auth.currentUser
                        Toast.makeText(this, "იმეილი და პაროლი წარმატებით დარეგისტრირდა. ახლა გაიარეთ ავტორიზაცია", Toast.LENGTH_LONG).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Register", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "რეგისტრაცია ვერ მოხერხდა", Toast.LENGTH_LONG).show()
                    }
                }

        }else{
            Toast.makeText(this, "შეიყვანეთ იმეილი და პაროლი რეგისტრაციის ველებში", Toast.LENGTH_LONG).show()
        }
    }
}