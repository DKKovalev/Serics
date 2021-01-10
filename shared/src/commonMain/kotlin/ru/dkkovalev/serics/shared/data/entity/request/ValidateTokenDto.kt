@file:Suppress("RUNTIME_ANNOTATION_NOT_SUPPORTED")

package ru.dkkovalev.serics.shared.data.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValidateTokenDto(
    @SerialName("username") val username: String,
    @SerialName("password") val password: String,
    @SerialName("request_token") val token: String
)
