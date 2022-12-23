import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.*

class LoggerTest {

    private lateinit var oldLogger: PlatformLogger

    @BeforeTest
    fun setUp() {
        oldLogger = Log.delegate
    }

    @AfterTest
    fun tearDown() {
        Log.delegate = oldLogger
    }

    @Test
    fun `performs logging`() {
        val testLogger = TestLogger().also {
            Log.delegate = it
        }

        LogTester().apply {
            performLogging("test message")
        }

        assertEquals("LogTester", testLogger.lastTag)
        assertEquals("test message", testLogger.lastMessage)
    }

    @Test
    fun `using logger extension in anonymous objects is prohibited`() {
        assertFails {
            object : Runnable {

                private val log = logger

                override fun run() {
                    log.d("dummy")
                }
            }
        }.also {
            assertIs<IllegalArgumentException>(it)
        }
    }
}

private class LogTester {

    private val log = logger

    fun performLogging(message: String) {
        log.d(message)
    }

}

private class TestLogger : PlatformLogger {

    var lastTag: String? = null
    var lastMessage: String? = null

    override fun d(tag: String, message: String) {
        lastTag = tag
        lastMessage = message
    }
}
