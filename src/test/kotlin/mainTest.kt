import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.IOException
import kotlin.test.assertEquals


class Test{

    @Test
    @Throws(IOException::class)
    fun serverSocketCreated() {
        val selectorManager = SelectorManager(Dispatchers.Default)
        val serverSocket = aSocket(selectorManager).tcp().bind("127.0.0.1", 8080)
        serverSocket.close()
        assertNotNull(serverSocket)
    }
    @Test
    @Throws(IOException::class)
    fun testPortOnSocket() {
        runBlocking {
            val selectorManager = SelectorManager(Dispatchers.Default)
            val serverSocket = aSocket(selectorManager).tcp().bind("127.0.0.1", 8080)

            assertEquals(serverSocket.localAddress.toString(), "/127.0.0.1:8080" )
            serverSocket.close()
        }
    }


}