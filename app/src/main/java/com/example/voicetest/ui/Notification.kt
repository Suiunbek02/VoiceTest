package com.example.voicetest.ui

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.voicetest.R

const val notificationID = 1
const val channelID = "channel1"
const val titleExtra = "titleExtra"
const val messageExtra = "messageExtra"

class Notification : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("TAG", "onReceive: ")
        context?.let {

            val notification = NotificationCompat.Builder(it, channelID)
                .setSmallIcon(R.drawable.ft)
                .setContentTitle(intent?.getStringExtra(titleExtra))
                .setContentText(intent?.getStringExtra(messageExtra))
                .setStyle(NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(notificationID, notification) }

    }
}