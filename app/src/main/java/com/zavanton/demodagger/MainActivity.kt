package com.zavanton.demodagger

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnTransactions = findViewById<Button>(R.id.btnTransactions)
        val btnOffers = findViewById<Button>(R.id.btnOffers)

        btnProfile.setOnClickListener {

        }

        btnTransactions.setOnClickListener {

        }

        btnOffers.setOnClickListener {

        }

    }
}
