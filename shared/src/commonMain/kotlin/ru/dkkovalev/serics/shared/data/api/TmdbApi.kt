package ru.dkkovalev.serics.shared.data.api

import ru.dkkovalev.serics.shared.data.entity.request.SessionRequestDto
import ru.dkkovalev.serics.shared.data.entity.response.MovieDto
import ru.dkkovalev.serics.shared.data.entity.response.RequestTokenDto
import ru.dkkovalev.serics.shared.data.entity.response.SessionResponseDto

interface TmdbApi {

    suspend fun getMoviesList(
        query: String,
        page: Int,
        includeAdult: Boolean = false
    ): MovieDto

    suspend fun getToken(): RequestTokenDto

    suspend fun requestNewSession(requestBody: SessionRequestDto): SessionResponseDto
}