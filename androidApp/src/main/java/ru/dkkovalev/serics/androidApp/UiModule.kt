package ru.dkkovalev.serics.androidApp

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import ru.dkkovalev.serics.androidApp.presentation.list.ListFragment
import ru.dkkovalev.serics.androidApp.presentation.list.PopularMoviesUi
import ru.dkkovalev.serics.androidApp.presentation.list.PopularShowsAdapter

val androidAppModule = DI.Module("androidAppModule") {
    bind<RequestManager>() with factory { fragment: Fragment -> Glide.with(fragment) }
}

val popularMoviesUiModule = DI.Module("popularMoviesUiModule") {
    bind<PopularMoviesUi>() with factory { fragment: ListFragment -> PopularMoviesUi(fragment) }
    bind<LinearLayoutManager>() with factory { context: Context ->
        LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
    }
    bind<PopularShowsAdapter>() with factory { requestManager: RequestManager ->
        PopularShowsAdapter(requestManager)
    }

    bind<DividerItemDecoration>() with factory { context: Context ->
        ContextCompat.getDrawable(context, R.drawable.list_divider)?.let {
            DividerItemDecoration(
                context,
                DividerItemDecoration.HORIZONTAL
            ).apply {
                setDrawable(it)
            }
        } ?: throw IllegalStateException("Divider drawable was not found")
    }
}