package com.example.app.core.data.networking

import com.example.app.core.domain.DataError
import com.example.app.core.domain.Result
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T, DataError.Remote> {
    val response = try {
        execute()
    } catch(e: UnresolvedAddressException) {
        return Result.Error(DataError.Remote.NoInternet)
    } catch(e: SerializationException) {
        return Result.Error(DataError.Remote.Serialization)
    } catch(e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(DataError.Remote.Unknown)
    }

    return responseToResult(response)
}