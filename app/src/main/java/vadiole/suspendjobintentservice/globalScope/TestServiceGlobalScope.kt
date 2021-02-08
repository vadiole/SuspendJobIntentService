package vadiole.suspendjobintentservice.globalScope

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestServiceGlobalScope : JobIntentService() {
    override fun onCreate() {
        super.onCreate()
        Log.i("TestServiceGlobalScope", "onCreate")
    }

    override fun onHandleWork(intent: Intent) {
        Log.i("TestServiceGlobalScope", "onHandleWork")
        GlobalScope.launch {
            for (i: Int in 0..Int.MAX_VALUE) {
                Log.i("TestServiceGlobalScope", "iteration $i")
                delay(1000)
            }
        }
    }

    override fun onDestroy() {
        Log.i("TestServiceGlobalScope", "onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val JOB_ID = 1001

        fun enqueueWork(context: Context) {
            enqueueWork(
                context,
                TestServiceGlobalScope::class.java,
                JOB_ID,
                Intent(context, TestServiceGlobalScope::class.java)
            )
        }
    }
}
