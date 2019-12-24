package handler.impl

import api.Api
import handler.DateHandler
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import model.BaseResponse
import org.koin.core.logger.Logger
import service.DateService

class DateHandlerImpl(
        private val dateService: DateService,
        private val logger: Logger
) : DateHandler {

    override suspend fun handle(call: ApplicationCall) {
        logger.info("handle query with params: ${call.parameters}")
        val year = call.parameters[Api.Params.year]?.toIntOrNull()
        val currentDate = call.parameters[Api.Params.currentDate]

        try {
            when {
                year != null -> {
                    call.respond(BaseResponse(Api.ErrorCodes.noError, dateService.find256day(year).toStringThatTeachersWant()))
                }
                currentDate != null -> {
                    call.respond(BaseResponse(Api.ErrorCodes.noError, dateService.leftToProgrammerDay(currentDate)))
                }
                else -> {
                    call.respond(HttpStatusCode.NotImplemented)
                }
            }
        } catch (t: Throwable) {
            call.respond(HttpStatusCode.BadRequest)
            logger.error("Catch throwable cause ${t.localizedMessage}")
        }
    }

}
