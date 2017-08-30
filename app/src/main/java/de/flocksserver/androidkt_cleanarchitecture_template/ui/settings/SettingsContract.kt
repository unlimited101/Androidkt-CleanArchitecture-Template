package de.flocksserver.androidkt_cleanarchitecture_template.ui.settings

import de.flocksserver.androidkt_cleanarchitecture_template.base.BasePresenter
import de.flocksserver.androidkt_cleanarchitecture_template.base.BaseView

/**
 * Created by marcel on 24.07.17.
 */
interface SettingsContract {
    interface View : BaseView {

        fun setSettings()


    }

    interface Presenter : BasePresenter<View> {

    }
}