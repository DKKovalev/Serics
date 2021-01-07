package ru.dkkovalev.serics.shared.data.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import ru.dkkovalev.serics.shared.data.entity.request.SessionRequestDto
import ru.dkkovalev.serics.shared.data.entity.response.MovieDto
import ru.dkkovalev.serics.shared.data.entity.response.RequestTokenDto
import ru.dkkovalev.serics.shared.data.entity.response.SessionResponseDto

class TmdbApiImpl(
    private val httpClient: HttpClient,
    private val language: String
) : TmdbApi {

    private val endpoint = ApiConsts.TMDB_ENDPOINT
    private val key = ApiConsts.TMDB_KEY

    override suspend fun getMoviesList(
        query: String,
        page: Int,
        includeAdult: Boolean
    ): MovieDto = httpClient.get {
        url {
            takeFrom("$endpoint/search/movie")
            parameter("api_key", key)
            parameter("language", language)
            parameter("query", query)
            parameter("page", page)
            parameter("include_adult", includeAdult)
        }
    }

    override suspend fun getToken(): RequestTokenDto = httpClient.get {
        url {
            takeFrom("$endpoint/authentication/token/new")
            parameter("api_key", key)
        }
    }

    override suspend fun requestNewSession(requestBody: SessionRequestDto): SessionResponseDto =
        httpClient.post {
            url {
                takeFrom("$endpoint/authentication/session/new")
                parameter("api_key", key)
                contentType(ContentType.Application.Json)
                body = requestBody
            }
        }
}