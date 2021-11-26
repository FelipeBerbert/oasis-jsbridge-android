package de.prosiebensat1digital.oasisjsbridge

import android.util.Log

object Logger {
    var jsBridgeLogger: LoggerInterface? = DefaultLogger()
        internal set

    fun i(tag: String? = null, message: String) = jsBridgeLogger?.log(Log.INFO, tag, message)
    fun w(tag: String? = null, message: String) = jsBridgeLogger?.log(Log.WARN, tag, message)
    fun w(tag: String? = null, throwable: Throwable) =
        jsBridgeLogger?.log(Log.WARN, tag, "", throwable)

    fun w(tag: String? = null, message: String, throwable: Throwable) =
        jsBridgeLogger?.log(Log.WARN, tag, message, throwable)

    fun d(tag: String? = null, message: String) = jsBridgeLogger?.log(Log.DEBUG, tag, message)
    fun e(tag: String? = null, message: String) = jsBridgeLogger?.log(Log.ERROR, tag, message)
    fun e(tag: String? = null, throwable: Throwable) =
        jsBridgeLogger?.log(Log.ERROR, tag, "", throwable)

    fun e(tag: String? = null, message: String, throwable: Throwable) =
        jsBridgeLogger?.log(Log.ERROR, tag, message, throwable)

    fun v(tag: String? = null, message: String) = jsBridgeLogger?.log(Log.VERBOSE, tag, message)
    fun wtf(tag: String? = null, message: String) = jsBridgeLogger?.log(Log.ASSERT, tag, message)
}

/**
 * Interface for implementing custom loggers, if no custom logger is set in [Logger.jsBridgeLogger]
 * it will default to [android.util.Log]
 */
interface LoggerInterface {
    /**
     * @param priority maps directly to [Log] priority
     */
    fun log(priority: Int, tag: String?, message: String, throwable: Throwable? = null)
}

class DefaultLogger : LoggerInterface {

    override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        when (priority) {
            Log.VERBOSE -> Log.v(tag, message)
            Log.DEBUG -> Log.d(tag, message)
            Log.INFO -> Log.i(tag, message)
            Log.WARN -> Log.w(tag, message, throwable)
            Log.ERROR -> Log.e(tag, message, throwable)
            Log.ASSERT -> Log.wtf(tag, message)
        }
    }
}
