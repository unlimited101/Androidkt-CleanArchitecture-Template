package de.flocksserver.androidkt_cleanarchitecture_template.di.components

import dagger.Component
import de.flocksserver.androidkt_cleanarchitecture_template.di.modules.ActivityModule
import de.flocksserver.androidkt_cleanarchitecture_template.di.modules.MainModule
import de.flocksserver.androidkt_cleanarchitecture_template.di.scope.PerFragment
import de.flocksserver.androidkt_cleanarchitecture_template.ui.MainActivity
import de.flocksserver.androidkt_cleanarchitecture_template.ui.content.ContentFragment
import de.flocksserver.androidkt_cleanarchitecture_template.ui.settings.SettingsFragment

@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class, MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(contentFragment: ContentFragment)

    fun inject(SettingsFragment: SettingsFragment)

}