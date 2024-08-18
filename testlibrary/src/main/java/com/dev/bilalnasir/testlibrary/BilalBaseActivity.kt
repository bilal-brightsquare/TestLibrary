package com.dev.bilalnasir.testlibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BilalBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                "Download : https://play.google.com/store/apps/details?id=$packagename"
            )
            intent.type = "text/plain"
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}