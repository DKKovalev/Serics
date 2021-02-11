package ru.dkkovalev.serics.shared.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ResultDto(
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("genre_ids") val genreIds: List<Int>,
    @SerialName("id") val id: Int,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("title") val title: String,
    @SerialName("vote_average") val averageVote: Double,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("origin_country") @Transient val originalCountry: List<String>? = null,
    @SerialName("adult") @Transient val isAdult: Boolean = false,
    @SerialName("release_date") @Transient val releaseDate: String? = null,
    @SerialName("first_air_date") @Transient val firstAirDate: String? = null,
    @SerialName("video") @Transient val isVideo: Boolean = false
)