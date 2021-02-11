package ru.dkkovalev.serics.shared.domain.series

import ru.dkkovalev.serics.shared.data.entity.model.Show

interface LoadPopularUseCase {
    suspend fun load(): List<Show>
}