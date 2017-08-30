package de.flocksserver.androidkt_cleanarchitecture_template.di.components

import android.content.Context
import dagger.Component
import de.flocksserver.androidkt_cleanarchitecture_template.App
import de.flocksserver.androidkt_cleanarchitecture_template.di.modules.ApplicationModule
import de.flocksserver.data.PerApplication
import de.flocksserver.domain.PostExecutionThread
import de.flocksserver.domain.ThreadExecutor
import de.flocksserver.domain.repository.MyRepository
import org.jetbrains.anko.AnkoLogger

@PerApplication
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(androidApplication: App)

    val androidApplication: App

    fun context(): Context

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun repository(): MyRepository

    fun logger(): AnkoLogger

}