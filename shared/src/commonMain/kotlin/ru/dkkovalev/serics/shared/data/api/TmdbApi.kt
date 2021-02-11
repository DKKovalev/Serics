package ru.dkkovalev.serics.shared.data.api

import ru.dkkovalev.serics.shared.data.entity.request.SessionRequestDto
import ru.dkkovalev.serics.shared.data.entity.request.ValidateTokenDto
import ru.dkkovalev.serics.shared.data.entity.response.*

interface TmdbApi {

    suspend fun getMoviesList(
        query: String,
        page: Int,
        includeAdult: Boolean = false
    ): MovieDto

    suspend fun getToken(): RequestTokenDto

    suspend fun requestNewSession(requestBody: SessionRequestDto): SessionResponseDto

    suspend fun validateToken(requestBody: ValidateTokenDto): RequestTokenDto

    suspend fun getMovieGenres(): GenresDto

    suspend fun getPopularMovies(): PopularShowDto

    suspend fun getPopularSeries(): PopularShowDto
}