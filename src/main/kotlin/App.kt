import handler.DateHandler
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import koin.appModule
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun Application.module() {

    install(Koin) {
        printLogger()
        modules(appModule)
    }
    install(ContentNegotiation) {
        gson()
    }

    val handler by inject<DateHandler>()

    routing {
        get(path = "/") {
            handler.handle(call)
        }
    }

}

fun main() {
    embeddedServer(Netty, port = 80, module = Application::module).start()
}
