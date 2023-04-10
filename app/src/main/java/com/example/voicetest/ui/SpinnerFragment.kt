package com.example.voicetest.ui

import android.app.*
import android.app.Notification
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.voicetest.R
import com.example.voicetest.databinding.FragmentSpinnerBinding
import java.lang.reflect.Array.set
import java.sql.Time
import java.util.*

class SpinnerFragment : Fragment(R.layout.fragment_spinner) {

    private val binding by viewBinding(FragmentSpinnerBinding::bind)

    @Deprecated("Deprecated in Java")
    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {

    }



}