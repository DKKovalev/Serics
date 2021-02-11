package ru.dkkovalev.serics.shared.data.mappers

import ru.dkkovalev.serics.shared.data.entity.model.Show
import ru.dkkovalev.serics.shared.data.entity.response.ResultDto

fun ResultDto.toShow(): Show = Show(
    title = title,
    originalTitle = originalTitle,
    description = overview,
    airDate = firstAirDate,
    coverUrl = posterPath,
    posterUrl = "https://www.themoviedb.org/t/p/w1280$posterPath"
)