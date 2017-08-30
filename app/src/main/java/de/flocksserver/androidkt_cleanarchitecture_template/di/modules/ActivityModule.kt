package de.flocksserver.androidkt_cleanarchitecture_template.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import de.flocksserver.androidkt_cleanarchitecture_template.di.scope.PerActivity

@Module
class ActivityModule(private val baseActivity: Activity) {

    @Provides
    @PerActivity
    internal fun provideActivity(): Activity {
        return this.baseActivity
    }
}