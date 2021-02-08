package vadiole.suspendjobintentservice

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.AlarmManagerCompat
import vadiole.suspendjobintentservice.globalScope.TestReceiverGlobalScope
import vadiole.suspendjobintentservice.runBlocking.TestReceiverRunBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alarmManager = getSystemService(Service.ALARM_SERVICE) as AlarmManager

        val intentGlobalScope = Intent(this, TestReceiverGlobalScope::class.java)
        val pendingIntentGlobalScope = PendingIntent.getBroadcast(
            this,
            1000,
            intentGlobalScope,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        val intentRunBlocking = Intent(this, TestReceiverRunBlocking::class.java)
        val pendingIntentRunBlocking = PendingIntent.getBroadcast(
            this,
            1000,
            intentRunBlocking,
            PendingIntent.FLAG_CANCEL_CURRENT
        )



        findViewById<View>(R.id.button_global_scope).setOnClickListener {
            Log.i("MainActivity", "delay global scope service")
            val timestampNow = System.currentTimeMillis()
            val timestampAlarm = timestampNow + 10000L

            AlarmManagerCompat.setExactAndAllowWhileIdle(
                alarmManager,
                AlarmManager.RTC_WAKEUP,
                timestampAlarm,
                pendingIntentGlobalScope
            )
        }

        findViewById<View>(R.id.button_run_blocking).setOnClickListener {
            Log.i("MainActivity", "delay run blocking service")
            val timestampNow = System.currentTimeMillis()
            val timestampAlarm = timestampNow + 10000L

            AlarmManagerCompat.setExactAndAllowWhileIdle(
                alarmManager,
                AlarmManager.RTC_WAKEUP,
                timestampAlarm,
                pendingIntentRunBlocking
            )
        }
    }
}
