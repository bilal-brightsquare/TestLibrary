package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BilalBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun DestroyAPP(message: String) {
        finishAffinity()
    }

    fun ShowToastCustom(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun ShareApp(packagename: String) {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.action = Intent.ACTION_SEND
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Download " + getString(R.string.app_name) + " now: https://play.google.com/store/apps/details?id=" + packagename
            )
            intent.type = "text/plain"
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}