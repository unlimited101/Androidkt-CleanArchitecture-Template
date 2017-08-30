package de.flocksserver.androidkt_cleanarchitecture_template.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import de.flocksserver.androidkt_cleanarchitecture_template.App
import de.flocksserver.androidkt_cleanarchitecture_template.Constants
import de.flocksserver.androidkt_cleanarchitecture_template.UIThread
import de.flocksserver.data.JobExecutor
import de.flocksserver.data.PerApplication
import de.flocksserver.data.persistence.DataStore
import de.flocksserver.data.service.TextService
import de.flocksserver.domain.PostExecutionThread
import de.flocksserver.domain.ThreadExecutor
import de.flocksserver.domain.repository.MyRepository
import org.jetbrains.anko.AnkoLogger

@Module
class ApplicationModule(private val androidApplication: App) {

    @Provides
    @PerApplication
    fun application(): App {
        return androidApplication
    }

    @Provides
    @PerApplication
    fun provideApplicationContext(): Context {
        return androidApplication
    }

    @Provides
    @PerApplication
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    fun provideSharedPreferences(): SharedPreferences {
        return androidApplication.getSharedPreferences(Constants.SHARE_PREF, Context.MODE_APPEND)
    }

    @Provides
    @PerApplication
    fun providesMyRepository(repo: DataStore): MyRepository {
        return repo
    }

    @Provides
    @PerApplication
    fun providesLogger(): AnkoLogger {
        return AnkoLogger("FLOCKSSERVER")
    }

    @Provides
    @PerApplication
    fun providesTextService(): TextService {
        return TextService()
    }
}
