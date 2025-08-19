package com.example.app.core.domain

sealed interface DataError: Error {
    sealed interface Remote: DataError {
        data object RequestTimeout: Remote
        data object TooManyRequests: Remote
        data object NoInternet: Remote
        data object Server: Remote
        data object Serialization: Remote
        data object Unknown: Remote
    }

    sealed interface Local: DataError {
        data object DiskFull: Local
        data object NotFoundInDatabase: Local
        data object Unknown: Local
    }
}