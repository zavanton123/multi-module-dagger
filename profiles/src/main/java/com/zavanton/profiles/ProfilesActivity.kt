package com.zavanton.profiles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProfilesActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            Intent(context, ProfilesActivity::class.java).also {
                context.startActivity(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles)
    }
}