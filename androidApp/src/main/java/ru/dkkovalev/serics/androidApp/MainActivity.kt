package ru.dkkovalev.serics.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.di
import org.kodein.di.instance
import ru.dkkovalev.serics.shared.domain.auth.RequestTokenUseCase

class MainActivity : AppCompatActivity(), DIAware {

    override val di: DI by di()

    private val useCase: RequestTokenUseCase by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch { useCase.getToken() }
    }
}
