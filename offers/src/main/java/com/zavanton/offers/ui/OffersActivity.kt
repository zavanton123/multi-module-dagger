package com.zavanton.offers.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zavanton.core.AppContext
import com.zavanton.offers.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class OffersActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            Intent(context, OffersActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

    @Inject
    @AppContext
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offers)

        Log.d("zavanton", "zavanton - offers appContext: $appContext")
    }
}
