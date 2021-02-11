package ru.dkkovalev.serics.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.di
import ru.dkkovalev.serics.androidApp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DIAware {

    override val di: DI by di()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
