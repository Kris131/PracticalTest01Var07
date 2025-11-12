package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import java.util.Random
import android.os.Process
import androidx.annotation.RequiresApi

class ProcessingThread(private val context: Context) : Thread() {

    var isRunning: Boolean = true
    private val random = Random()

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun run() {
        Log.d("Thread_Process", "Thread has started! PID: " + Process.myPid() + " TID: " + Process.myTid())
        while (isRunning) {
            sendMessage()
            mySleep(10000)
        }

        Log.d("Thread_Process", "Thread has stopped!")
    }

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    private fun sendMessage() {
        val nr1 = random.nextInt(0, 100)
        val nr2 = random.nextInt(0, 100)
        val nr3 = random.nextInt(0, 100)
        val nr4 = random.nextInt(0, 100)

        val intent = Intent()
        intent.setAction("ProcessingThread")
        intent.putExtra("nr1", nr1)
        intent.putExtra("nr2", nr2)
        intent.putExtra("nr3", nr3)
        intent.putExtra("nr4", nr4)

        context.sendBroadcast(intent)
    }

    private fun mySleep(millis: Long) {
        try {
            sleep(millis)
        } catch (interruptedException: InterruptedException) {
            interruptedException.printStackTrace()
        }
    }

    fun stopThread() {
        isRunning = false
    }
}
