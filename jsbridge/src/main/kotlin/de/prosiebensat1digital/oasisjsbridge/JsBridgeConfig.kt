package de.prosiebensat1digital.oasisjsbridge

import android.util.Log
import okhttp3.OkHttpClient

class JsBridgeConfig
private constructor() {
    companion object {
        @JvmStatic
        fun bareConfig() = JsBridgeConfig()

        @JvmStatic
        fun standardConfig() = JsBridgeConfig().apply {
            setTimeoutConfig.enabled = true
            xhrConfig.enabled = true
            promiseConfig.enabled = true
            consoleConfig.enabled = true
        }
    }

    /**
     * Pseudo builder function.
     */
    fun withLogger(loggerImpl: LoggerInterface): JsBridgeConfig {
        loggerImpl.let { Logger.jsBridgeLogger = it }
        return this
    }

    val setTimeoutConfig = SetTimeoutExtensionConfig()
    val xhrConfig = XMLHttpRequestConfig()
    val promiseConfig = PromiseConfig()
    val consoleConfig = ConsoleConfig()
    val jsDebuggerConfig = JsDebuggerConfig()

    class SetTimeoutExtensionConfig {
        var enabled: Boolean = false
    }

    class XMLHttpRequestConfig {
        var enabled: Boolean = false
        var okHttpClient: OkHttpClient? = null
        var userAgent: String? = null
    }

    class PromiseConfig {
        var enabled: Boolean = false
        val needsPolyfill = !BuildConfig.HAS_BUILTIN_PROMISE
    }

    class ConsoleConfig {
        enum class Mode {
            AsString, AsJson, Empty
        }

        var enabled: Boolean = false
        var mode: Mode = Mode.AsString
        var appendMessage: (priority: Int, message: String) -> Unit = { priority, message ->
            when (priority) {
                Log.DEBUG -> Logger.d("JavaScript", message)
                Log.ERROR -> Logger.e("JavaScript", message)
                Log.INFO -> Logger.i("JavaScript", message)
                Log.VERBOSE -> Logger.v("JavaScript", message)
                Log.WARN -> Logger.w("JavaScript", message)
                Log.ASSERT -> Logger.wtf("JavaScript", message)
            }
        }
    }

    class JsDebuggerConfig {
        var enabled: Boolean = false
        var port: Int = 9092
    }
}
