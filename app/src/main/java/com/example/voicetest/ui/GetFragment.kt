package com.example.voicetest.ui

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.voicetest.R
import com.example.voicetest.databinding.FragmentGetBinding
import java.util.Calendar


class GetFragment : Fragment(R.layout.fragment_get) {

    private val binding by viewBinding(FragmentGetBinding::bind)
    private var alarmManager: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent

    @Deprecated("Deprecated in Java")
    override fun onAttach(context: Context) {
        super.onAttach(context)
        creatNotificationChannel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnPush.setOnClickListener {
            schedulNotiffication()
            get()
//            notifincation()
        }
    }

    @SuppressLint("ShortAlarm", "SuspiciousIndentation", "UnspecifiedImmutableFlag")
    private fun schedulNotiffication() {
        binding.btnPush.setBackgroundColor(R.drawable.baseline_check_24)
        alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(context, Notification::class.java).let { intent ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_MUTABLE)
            } else {
                TODO("VERSION.SDK_INT < S")
            }

        }

        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 8)
            set(Calendar.MINUTE, 50)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

        alarmManager?.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )
    }

    @SuppressLint("ShortAlarm", "SuspiciousIndentation", "UnspecifiedImmutableFlag")
    private fun get() {
        alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(context, Notification::class.java).let { intent ->
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_MUTABLE)

        }

        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 11)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)

        }

        alarmManager?.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )
    }

//    @SuppressLint("UnspecifiedImmutableFlag")
//    private fun notifincation() {
//        alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        alarmIntent = Intent(context, Notification::class.java).let { intent ->
//            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_MUTABLE)
//
//        }
//
//        val calendar: Calendar = Calendar.getInstance().apply {
//            timeInMillis = System.currentTimeMillis()
//            set(Calendar.HOUR_OF_DAY, 11)
//            set(Calendar.MINUTE, 40)
//            set(Calendar.SECOND, 0)
//
//        }
//
//        alarmManager?.setRepeating(
//            AlarmManager.RTC_WAKEUP,
//            calendar.timeInMillis,
//            AlarmManager.INTERVAL_DAY,
//            alarmIntent
//        )
//    }

    private fun creatNotificationChannel() {
        val name = "Notif Channel"
        val desc = "A description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelID, name, importance)
            channel.description = desc
            val notificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}