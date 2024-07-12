package com.example.sampleapp.utils

import android.os.Handler


class Throttler(private val thresholdMs: Long) {
    private val handler: Handler = Handler()

    fun publish(runnable: Runnable) {
        if (handler.hasMessages(WHAT)) {
            return
        }

        runnable.run()
        handler.sendMessageDelayed(handler.obtainMessage(WHAT), thresholdMs)
    }

    fun clear() {
        handler.removeCallbacksAndMessages(null)
    }

    companion object {
        private const val WHAT = 8675309
    }
}