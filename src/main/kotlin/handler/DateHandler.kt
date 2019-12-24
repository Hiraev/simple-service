package handler

import io.ktor.application.ApplicationCall

interface DateHandler {

    suspend fun handle(call: ApplicationCall)

}
