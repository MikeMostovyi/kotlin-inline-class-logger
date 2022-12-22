class LoggerTestDrive {

    private val log = logger

    fun doSomething() {
        log.d("doSomething is called")
    }

    fun printValue(name: String, value: Any) {
        log.d("value of '$name' is: $value")
    }

    fun printArray(array: Array<String>) {
        log.d("Array data:")
        array.forEachIndexed { index, value ->
            log.d("array[$index] = $value")
        }
    }
}