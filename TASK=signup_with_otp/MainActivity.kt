package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.task.databinding.ActivityMainBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var varificationid: String
    lateinit var auth: FirebaseAuth
    lateinit var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()


        binding.send.setOnClickListener {
            var phone = binding.mobile.text.toString()
            if (phone.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "please enter a valid number",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                sendverificationcode(phone)
            }
        }
        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                var code = p0.smsCode
                if (code != null) {
                    binding.otp.setText(code)
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show();
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                varificationid = p0
            }
        }
        binding.btn.setOnClickListener {
            var otp = binding.otp.text.toString()

            if (otp.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "please enter a valid OTP",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                verifycode(otp)
            }
        }
    }

    private fun sendverificationcode(phone: String) {
        PhoneAuthProvider.getInstance()
            .verifyPhoneNumber(phone, 60, TimeUnit.SECONDS, this, mCallback)
    }

    private fun verifycode(otp: String) {
        var credential = PhoneAuthProvider.getCredential(varificationid, otp)
        signinwithcredential(credential)
    }

    private fun signinwithcredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(applicationContext, "SUCESS", Toast.LENGTH_SHORT).show()

                var fname = binding.fname.text.toString()
                var lname = binding.lname.text.toString()
                var email = binding.email.text.toString()
                var phone = binding.mobile.text.toString()
                var pass = binding.pass.text.toString()

                var StringRequest: StringRequest = object : StringRequest(
                    Request.Method.POST, "https://vyasprakruti.000webhostapp.com/BatchTask/insert.php",
                    Response.Listener {
                        Toast.makeText(applicationContext, "Record sign_up Successfully", Toast.LENGTH_SHORT).show()
                    },
                    Response.ErrorListener {
                        Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()
                    }) {
                    override fun getParams(): MutableMap<String, String>? {
                        var map = HashMap<String, String>()
                        map["firstname"] = fname
                        map["lastname"] = lname
                        map["email"] = email
                        map["mobile"] = phone
                        map["password"] = pass
                        return map
                    }
                }
                var queue: RequestQueue = Volley.newRequestQueue(this)
                queue.add(StringRequest)
            } else {
                Toast.makeText(applicationContext, "ERROR", Toast.LENGTH_SHORT).show()

            }
        }
    }
}
