package koin

import handler.DateHandler
import handler.impl.DateHandlerImpl
import org.koin.core.logger.Logger
import org.koin.core.logger.PrintLogger
import org.koin.dsl.module
import service.DateService
import service.impl.DateServiceImpl

val appModule = module {
    single<DateHandler> { DateHandlerImpl(get(), get()) }
    single<Logger> { PrintLogger() }
    single<DateService> { DateServiceImpl() }
}
