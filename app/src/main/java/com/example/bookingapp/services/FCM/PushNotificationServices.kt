package com.example.bookingapp.services.FCM

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.bookingapp.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.RemoteMessage.Notification

class PushNotificationServices() : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        message.notification?.let {
            createNotification(it)
            // Handle the notification message here.
        }
    }

    private fun createNotification(notification: RemoteMessage.Notification) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel = NotificationChannel(
            applicationContext.getString(R.string.channel_id),
            applicationContext.getString(R.string.channel_name),
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)

        val builder = NotificationCompat.Builder(applicationContext, applicationContext.getString(R.string.channel_id))
            .setSmallIcon(R.drawable.ic_notifications_black_24dp)
            .setContentTitle(applicationContext.getString(R.string.app_name))
            .setContentText(notification.body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val notificationId = 1
        notificationManager.notify(notificationId, builder.build())
    }
}