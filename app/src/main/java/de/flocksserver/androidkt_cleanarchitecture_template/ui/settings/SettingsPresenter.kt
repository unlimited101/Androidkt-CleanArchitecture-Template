package de.flocksserver.androidkt_cleanarchitecture_template.ui.settings

import de.flocksserver.androidkt_cleanarchitecture_template.base.BasePresenter
import de.flocksserver.androidkt_cleanarchitecture_template.di.scope.PerFragment
import de.flocksserver.androidkt_cleanarchitecture_template.ui.settings.SettingsContract
import javax.inject.Inject

/**
 * Created by marcel on 24.07.17.
 */
@PerFragment
class SettingsPresenter @Inject constructor() : BasePresenter<SettingsContract.View>, SettingsContract.Presenter {

    override var view: SettingsContract.View? = null

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
        view = null
    }
}