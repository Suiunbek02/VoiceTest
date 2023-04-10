package com.example.voicetest.ui

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.location.Geocoder.GeocodeListener
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.graphics.toColor
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.voicetest.R
import com.example.voicetest.databinding.FragmentTestBinding
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import java.util.*


class TestFragment : Fragment(R.layout.fragment_test) {

    private val binding by viewBinding(FragmentTestBinding::bind)
    private var progr_counter = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProgressBar()
        binding.btnPush.setOnClickListener {
            setupListener()
        }
    }

    private fun getProgressBar() = with(binding) {
        bottom.setOnClickListener {
            Handler().postDelayed({
                binding.progressBar.progress = 0F
                binding.text.text = "0"
            }, 55000)

            if (progr_counter <= 2500) {
                progr_counter += 200
                moveProgressBar()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun moveProgressBar() {
        binding.progressBar.progress = progr_counter.toFloat()
        binding.text.text = "$progr_counter"

    }

    private fun setupListener() {

        binding.btn.setOnClickListener {
            findNavController().navigate(
                R.id.action_testFragment_to_getFragment
            )
        }
    }
}