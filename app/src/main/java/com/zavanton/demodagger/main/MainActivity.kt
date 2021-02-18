package com.zavanton.demodagger.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.zavanton.demodagger.R
import com.zavanton.demodagger.app.App
import com.zavanton.demodagger.app.di.AppContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @AppContext
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        (this.application as App)
            .applicationComponent
            ?.mainActivitySubcomponentFactory()
            ?.build()
            ?.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("zavanton", "zavanton - app context: $appContext")

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
