package vadiole.suspendjobintentservice.runBlocking

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class TestReceiverRunBlocking : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        Log.i("TestReceiverRunBlocking", "onReceive")
        TestServiceRunBlocking.enqueueWork(context)
    }
}
