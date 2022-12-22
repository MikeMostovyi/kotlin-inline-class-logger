@JvmInline
value class Logger(
    private val tag: String
) {

    fun d(message: String) {
        Log.d(tag, message)
    }
}

val Any.logger: Logger
    get() {
        val tag = requireNotNull(this::class.simpleName) {
            "This logger cannot be used in anonymous classes"
        }
        return Logger(tag)
    }
