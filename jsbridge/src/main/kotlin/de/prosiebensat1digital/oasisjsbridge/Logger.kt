package de.prosiebensat1digital.oasisjsbridge

interface LoggerInterface {
    fun i(message: String)
    fun w(message: String)
    fun w(throwable: Throwable)
    fun d(message: String)
    fun e(message: String)
    fun e(throwable: Throwable)
    fun v(message: String)
}

object Logger {
    var logger: LoggerInterface? = null

    fun i(message: String) = logger?.i(message)
    fun w(message: String) = logger?.w(message)
    fun w(throwable: Throwable) = logger?.w(throwable)
    fun d(message: String) = logger?.d(message)
    fun e(message: String) = logger?.e(message)
    fun e(throwable: Throwable) = logger?.e(throwable)
    fun v(message: String) = logger?.v(message)
}
