package com.example.pr_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var btn: Button

    val pattern = ("[a-zA-Z0-9]{1,100}"+"@"+"[a-z]{1,10}"+"\\."+"[a-z]{1,4}")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.textPersonName)
        btn = findViewById(R.id.button)

        email.addTextChangedListener {
            editContent()
        }
    }
        private fun editContent(){
            if (email.text.toString().isNotEmpty())
            {
                btn.setBackgroundResource(R.drawable.btn)
                btn.isClickable = true
            }
            else
            {
                btn.setBackgroundResource(R.drawable.btn2)
                btn.isClickable = false
            }
        }
        fun emailValid(text: String):Boolean
        {
            return Pattern.compile(pattern).matcher(text).matches()
        }
        fun login(view: View) {
            if (emailValid(email.text.toString())) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Поле e-mail некорректно заполнено", Toast.LENGTH_SHORT).show()
            }
        }
}