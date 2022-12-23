
interface PlatformLogger {

    fun d(tag: String, message: String)
}

class PrintlnLogger : PlatformLogger {

    override fun d(tag: String, message: String) {
        println("$tag: $message")
    }
}

/**
 * A simulation of a platform logger. The idea for this one is taken from Android.
 */
object Log {

    var delegate: PlatformLogger = PrintlnLogger()

    @JvmStatic
    fun d(tag: String, message: String) {
        delegate.d(tag, message)
    }
}
