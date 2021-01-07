package ru.dkkovalev.serics.shared.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionResponseDto(
    @SerialName("success") val success: Boolean,
    @SerialName("session_id") val sessionId: String
)
