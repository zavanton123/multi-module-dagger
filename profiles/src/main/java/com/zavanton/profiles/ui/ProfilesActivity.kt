package com.zavanton.profiles.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zavanton.core.AppContext
import com.zavanton.profiles.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class ProfilesActivity : AppCompatActivity() {

    @Inject
    @AppContext
    lateinit var appContext: Context

    @Inject
    lateinit var presenter: ProfilesActivityPresenter

    companion object {
        fun start(context: Context) {
            Intent(context, ProfilesActivity::class.java).also {
                context.startActivity(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles)

        Log.d("zavanton", "zavanton - profiles appContext: $appContext")
    }
}