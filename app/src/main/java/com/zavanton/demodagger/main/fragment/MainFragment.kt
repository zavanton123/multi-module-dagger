package com.zavanton.demodagger.main.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.zavanton.core.AppContext
import com.zavanton.demodagger.R
import com.zavanton.offers.ui.OffersActivity
import com.zavanton.profiles.ui.ProfilesActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    @Inject
    @AppContext
    lateinit var appContext: Context

    @Inject
    lateinit var presenter: MainFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("zavanton", "zavanton - app context: $appContext")

        val btnProfile = view.findViewById<Button>(R.id.btnProfile)
        val btnTransactions = view.findViewById<Button>(R.id.btnTransactions)
        val btnOffers = view.findViewById<Button>(R.id.btnOffers)

        btnProfile.setOnClickListener {
            ProfilesActivity.start(requireContext())
        }

        btnTransactions.setOnClickListener {

        }

        btnOffers.setOnClickListener {
            OffersActivity.start(requireContext())
        }
    }
}