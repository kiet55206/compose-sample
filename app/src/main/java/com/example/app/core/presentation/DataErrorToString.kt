package com.example.app.core.presentation

import com.example.app.R
import com.example.app.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringRes = when (this) {
        DataError.Local.DiskFull -> R.string.error_disk_full
        DataError.Local.NotFoundInDatabase -> R.string.error_not_found_in_database
        DataError.Local.Unknown -> R.string.error_unknown
        DataError.Remote.RequestTimeout -> R.string.error_request_timeout
        DataError.Remote.TooManyRequests -> R.string.error_too_many_requests
        DataError.Remote.NoInternet -> R.string.error_no_internet
        DataError.Remote.Server -> R.string.error_unknown
        DataError.Remote.Serialization -> R.string.error_serialization
        DataError.Remote.Unknown -> R.string.error_unknown
    }

    return UiText.StringResource(stringRes)
}
