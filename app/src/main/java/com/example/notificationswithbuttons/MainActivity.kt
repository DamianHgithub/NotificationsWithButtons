package com.example.notificationswithbuttons

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationswithbuttons.databinding.ActivityMainBinding
import com.example.notificationswithbuttons.di.DIManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val mNotification = NotificationCompat.Builder(this, DIManager.channelID)
            .setSmallIcon(R.drawable.ic_android_white_24dp)
            .setContentText("Try out these new, sweet buttons!")
            .setContentTitle("Notification with buttons.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(R.drawable.ic_android_white_24dp, "Test", pendingIntent)
            .build()

        NotificationManagerCompat.from(this).notify(1, mNotification)
    }
}