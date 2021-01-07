package ru.dkkovalev.serics.androidApp

import android.content.Context
import com.russhwolf.settings.AndroidSettings
import ru.dkkovalev.serics.shared.SericsSDK
import ru.dkkovalev.serics.shared.data.api.HttpClientFactory

fun SericsSDK.Companion.create(context: Context, locale: String, isDebug: Boolean): SericsSDK {

    val prefs = context.getSharedPreferences("serics_prefs", Context.MODE_PRIVATE)

    return SericsSDK(
        locale,
        isDebug,
        HttpClientFactory(),
        AndroidSettings(prefs)
    )
}