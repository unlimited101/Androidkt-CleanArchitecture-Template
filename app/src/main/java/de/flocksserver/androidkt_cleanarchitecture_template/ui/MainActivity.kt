package de.flocksserver.androidkt_cleanarchitecture_template.ui

import android.os.Bundle
import de.flocksserver.androidkt_cleanarchitecture_template.R
import de.flocksserver.androidkt_cleanarchitecture_template.base.BaseActivity
import de.flocksserver.androidkt_cleanarchitecture_template.di.HasComponent
import de.flocksserver.androidkt_cleanarchitecture_template.di.components.DaggerMainComponent
import de.flocksserver.androidkt_cleanarchitecture_template.di.components.MainComponent
import de.flocksserver.androidkt_cleanarchitecture_template.di.modules.MainModule
import de.flocksserver.androidkt_cleanarchitecture_template.ui.content.ContentFragment
import de.flocksserver.androidkt_cleanarchitecture_template.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by marcel on 24.07.17.
 */
class MainActivity : BaseActivity(), HasComponent<MainComponent> {
    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeActivity()
    }

    private fun initializeActivity() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_miniworlds ->
                    replaceFragment(R.id.container, ContentFragment.newInstance())
                R.id.navigation_settings ->
                    replaceFragment(R.id.container, SettingsFragment.newInstance())
            }
            true
        }
        replaceFragment(R.id.container, ContentFragment.newInstance())
    }

    //TODO: Android Injector
    private val mainComponent: MainComponent
        get() = DaggerMainComponent.builder()
            .applicationComponent(getApplicationComponent())
            .mainModule(MainModule(this))
            .build()

    override fun getComponent(): MainComponent {
        return mainComponent
    }
}
