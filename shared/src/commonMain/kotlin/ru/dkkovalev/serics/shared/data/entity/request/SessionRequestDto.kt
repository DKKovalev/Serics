package ru.dkkovalev.serics.shared.data.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionRequestDto(
    @SerialName("serial_token") val token: String
)
