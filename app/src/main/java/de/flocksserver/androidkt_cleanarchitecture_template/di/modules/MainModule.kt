package de.flocksserver.androidkt_cleanarchitecture_template.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import de.flocksserver.androidkt_cleanarchitecture_template.di.scope.PerActivity
import de.flocksserver.androidkt_cleanarchitecture_template.di.scope.PerFragment
import de.flocksserver.androidkt_cleanarchitecture_template.model.mapper.ItemViewMapper
import de.flocksserver.androidkt_cleanarchitecture_template.ui.MainActivity

/**
 * Created by marcel on 08.08.17.
 */
@Module
class MainModule(private val mainActivity: MainActivity) {

    @Provides
    @PerFragment
    internal fun provideActivity(): MainActivity {
        return this.mainActivity
    }
    @Provides
    @PerFragment
    internal fun provideItemViewMapper(context: Context): ItemViewMapper {
        return ItemViewMapper(context)
    }
}