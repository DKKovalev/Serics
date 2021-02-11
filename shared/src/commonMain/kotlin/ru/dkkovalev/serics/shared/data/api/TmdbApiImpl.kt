package ru.dkkovalev.serics.shared.data.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import ru.dkkovalev.serics.shared.data.entity.request.SessionRequestDto
import ru.dkkovalev.serics.shared.data.entity.request.ValidateTokenDto
import ru.dkkovalev.serics.shared.data.entity.response.*
import ru.dkkovalev.serics.shared.data.utils.SettingsHolder

class TmdbApiImpl(
    private val httpClient: HttpClient,
    settingsHolder: SettingsHolder
) : TmdbApi {

    private val endpoint = ApiConsts.TMDB_ENDPOINT
    private val key = ApiConsts.TMDB_KEY

    private val language = settingsHolder.getLocale()

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

    override suspend fun requestNewSession(
        requestBody: SessionRequestDto
    ): SessionResponseDto = httpClient.post {
        url {
            takeFrom("$endpoint/authentication/session/new")
            parameter("api_key", key)
            contentType(ContentType.Application.Json)
            body = requestBody
        }
    }

    override suspend fun validateToken(
        requestBody: ValidateTokenDto
    ): RequestTokenDto = httpClient.post {
        url {
            takeFrom("$endpoint/authentication/token/validate_with_login")
            parameter("api_key", key)
            contentType(ContentType.Application.Json)
            body = requestBody
        }
    }

    override suspend fun getMovieGenres(): GenresDto = httpClient.get {
        url {
            takeFrom("$endpoint/genre/movie/list")
            parameter("api_key", key)
            parameter("language", language)
        }
    }

    override suspend fun getPopularMovies(): PopularShowDto = httpClient.get {
        url {
            takeFrom("$endpoint/movie/popular")
            parameter("api_key", key)
            parameter("language", language)
        }
    }

    override suspend fun getPopularSeries(): PopularShowDto = httpClient.get {
        url {
            takeFrom("$endpoint/tv/popular")
            parameter("api_key", key)
            parameter("language", language)
        }
    }
}