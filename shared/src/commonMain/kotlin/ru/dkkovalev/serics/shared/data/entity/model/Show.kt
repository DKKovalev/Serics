package ru.dkkovalev.serics.shared.data.entity.model

//TODO Think about more convenient name
data class Show(
    val title: String,
    val originalTitle: String,
    val description: String,
    val airDate: String?,
    val coverUrl: String?,
    val posterUrl: String?
)
