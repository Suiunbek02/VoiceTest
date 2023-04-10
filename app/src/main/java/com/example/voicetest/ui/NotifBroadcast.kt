package com.example.voicetest.ui

import android.annotation.SuppressLint
import android.app.AlertDialog.Builder
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.voicetest.R

class NotifBroadcast : BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent: Intent?) {
        val intent = Intent(context, TestFragment::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent =
            PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(context, "Notification")
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ft)
            .setLargeIcon(
                Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(
                        context.resources,
                        R.drawable.food,
                    ), 128, 128, false
                )
            )
            .setContentTitle("FoodTracker")
            .setContentText("вы должны завтракать")
            .setPriority(android.app.Notification.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        val notificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManagerCompat.notify(200, builder.build())

    }
}