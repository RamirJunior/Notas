package com.example.notas

import android.app.Application
import com.example.notas.data.di.DependencyModules
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin(this, listOf(DependencyModules.appModule))
    }

}