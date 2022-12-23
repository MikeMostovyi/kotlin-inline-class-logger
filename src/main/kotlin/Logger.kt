@JvmInline
value class Logger(
    val tag: String
) {

    @Suppress("NOTHING_TO_INLINE")
    inline fun d(message: String) {
        Log.d(tag, message)
    }
}

val Any.logger: Logger
    get() {
        val tag = requireNotNull(this::class.simpleName) {
            "This logger cannot be used in anonymous objects"
        }
        return Logger(tag)
    }
