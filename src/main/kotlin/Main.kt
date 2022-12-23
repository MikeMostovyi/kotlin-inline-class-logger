fun main(args: Array<String>) {
    LoggerTestDrive().apply {
        doSomething()
        printValue("Math.PI", Math.PI)
        printValue("Math.E", Math.E)
        printArray(args)
    }
}
