package com.example.app.core.data.networking

import com.example.app.core.domain.DataError
import com.example.app.core.domain.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, DataError.Remote> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(DataError.Remote.Serialization)
            }
        }

        408 -> Result.Error(DataError.Remote.RequestTimeout)
        429 -> Result.Error(DataError.Remote.TooManyRequests)
        in 500..599 -> Result.Error(DataError.Remote.Server)
        else -> Result.Error(DataError.Remote.Unknown)
    }
}