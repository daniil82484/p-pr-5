package com.example.pr_2
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class LoginActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var name2: EditText
    lateinit var name3: EditText
    lateinit var name4: EditText
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        name = findViewById(R.id.textPersonName)
        name2 = findViewById(R.id.textPersonName2)
        name3 = findViewById(R.id.textPersonName3)
        name4 = findViewById(R.id.textPersonName4)
        btn = findViewById(R.id.btn2)
        name.addTextChangedListener {
            editContent()
        }
        name2.addTextChangedListener {
            editContent()
        }
        name3.addTextChangedListener {
            editContent()
        }
        name4.addTextChangedListener {
            editContent()
        }
    }
    private fun editContent(){
        if (name.text.toString().isNotEmpty() && name2.text.toString().isNotEmpty() && name3.text.toString().isNotEmpty() && name4.text.toString().isNotEmpty())
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
    fun login(view: View) {
        val intent = Intent(this, MainPageActivity::class.java)
        startActivity(intent)
        finish()
    }
}


