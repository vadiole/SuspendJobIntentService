package vadiole.suspendjobintentservice.runBlocking

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class TestServiceRunBlocking : JobIntentService() {
    override fun onCreate() {
        super.onCreate()
        Log.i("TestServiceRunBlocking", "onCreate")
    }

    override fun onHandleWork(intent: Intent) = runBlocking {
        Log.i("TestServiceRunBlocking", "onHandleWork")

        for (i: Int in 0..Int.MAX_VALUE) {
            Log.i("TestServiceRunBlocking", "iteration $i")
            delay(1000)
        }
    }

    override fun onDestroy() {
        Log.i("TestServiceRunBlocking", "onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val JOB_ID = 1000

        fun enqueueWork(context: Context) {
            enqueueWork(
                context,
                TestServiceRunBlocking::class.java,
                JOB_ID,
                Intent(context, TestServiceRunBlocking::class.java)
            )
        }
    }
}
