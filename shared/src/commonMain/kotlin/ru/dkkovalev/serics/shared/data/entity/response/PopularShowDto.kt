package ru.dkkovalev.serics.shared.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularShowDto(
    @SerialName("page") val currentPage: Int,
    @SerialName("results") val results: List<ResultDto>
)
