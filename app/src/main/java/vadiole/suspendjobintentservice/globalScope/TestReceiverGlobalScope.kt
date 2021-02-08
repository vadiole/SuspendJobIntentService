package vadiole.suspendjobintentservice.globalScope

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class TestReceiverGlobalScope : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        Log.i("TestReceiverGlobalScope", "onReceive")
        TestServiceGlobalScope.enqueueWork(context)
    }
}
