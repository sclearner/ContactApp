package com.samnn.contactapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val display = supportActionBar

        try {
            val name = intent.getStringExtra("name")
            val phone = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)
            val email = intent.getStringExtra(Intent.EXTRA_EMAIL)

            display?.title = name
            display?.setDisplayHomeAsUpEnabled(true)

            findViewById<TextView>(R.id.contact_name_show).text = name
            findViewById<TextView>(R.id.phone_number).text = phone
            findViewById<TextView>(R.id.email_show).text = email
        }
        catch (ex: Exception) {
            setResult(Activity.RESULT_CANCELED)
        }
    }
}