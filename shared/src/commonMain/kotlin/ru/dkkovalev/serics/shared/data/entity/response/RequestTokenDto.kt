package ru.dkkovalev.serics.shared.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestTokenDto(
    @SerialName("success") val isSuccess: Boolean,
    @SerialName("expires_at") val expires: String,
    @SerialName("request_token") val requestToken: String
)
