package de.prosiebensat1digital.oasisjsbridge

import android.util.Log

interface LoggerInterface {
    fun i(tag: String?, message: String)
    fun w(tag: String?, message: String)
    fun w(tag: String?, throwable: Throwable)
    fun w(tag: String?, message: String, throwable: Throwable)
    fun d(tag: String?, message: String)
    fun e(tag: String?, message: String)
    fun e(tag: String?, throwable: Throwable)
    fun e(tag: String?, message: String, throwable: Throwable)
    fun v(tag: String?, message: String)
    fun wtf(tag: String?, message: String)
}

object Logger {
    var jsBridgeLogger: LoggerInterface? = DefaultLogger()

    fun i(tag: String? = null, message: String) = jsBridgeLogger?.i(tag, message)
    fun w(tag: String? = null, message: String) = jsBridgeLogger?.w(tag, message)
    fun w(tag: String? = null, throwable: Throwable) = jsBridgeLogger?.w(tag, throwable)
    fun w(tag: String? = null, message: String, throwable: Throwable) = jsBridgeLogger?.w(tag, message, throwable)
    fun d(tag: String? = null, message: String) = jsBridgeLogger?.d(tag, message)
    fun e(tag: String? = null, message: String) = jsBridgeLogger?.e(tag, message)
    fun e(tag: String? = null, throwable: Throwable) = jsBridgeLogger?.e(tag, throwable)
    fun e(tag: String? = null, message: String, throwable: Throwable) = jsBridgeLogger?.e(tag, message, throwable)
    fun v(tag: String? = null, message: String) = jsBridgeLogger?.v(tag, message)
    fun wtf(tag: String? = null, message: String) = jsBridgeLogger?.wtf(tag, message)
}

class DefaultLogger : LoggerInterface {
    override fun i(tag: String?, message: String) {
        Log.i(tag, message)
    }

    override fun w(tag: String?, message: String) {
       Log.w(tag, message)
    }

    override fun w(tag: String?, throwable: Throwable) {
        Log.w(tag, throwable)
    }

    override fun w(tag: String?, message: String, throwable: Throwable) {
        Log.w(tag, message, throwable)
    }

    override fun d(tag: String?, message: String) {
        Log.d(tag, message)
    }

    override fun e(tag: String?, message: String) {
        Log.e(tag, message)
    }

    override fun e(tag: String?, throwable: Throwable) {
        Log.e(tag, "", throwable)
    }

    override fun e(tag: String?, message: String, throwable: Throwable) {
        Log.e(tag, message, throwable)
    }

    override fun v(tag: String?, message: String) {
        Log.v(tag, message)
    }

    override fun wtf(tag: String?, message: String) {
        Log.wtf(tag, message)
    }
}
