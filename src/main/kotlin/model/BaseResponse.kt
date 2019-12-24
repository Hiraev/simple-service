package model

data class BaseResponse<T>(
        val errorCode: Int,
        val dateMessage: T
)
