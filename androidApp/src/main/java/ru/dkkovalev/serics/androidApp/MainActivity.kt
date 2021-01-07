package ru.dkkovalev.serics.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.dkkovalev.serics.shared.SericsSDK

class MainActivity : AppCompatActivity() {

    private lateinit var sericsSDK: SericsSDK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sericsSDK = SericsSDK.create(
            this,
            "ru_RU",
            true
        )

        GlobalScope.launch {
            println(sericsSDK.getMoviesUseCase().getMovies("chicken run", 1))
        }

    }
}
