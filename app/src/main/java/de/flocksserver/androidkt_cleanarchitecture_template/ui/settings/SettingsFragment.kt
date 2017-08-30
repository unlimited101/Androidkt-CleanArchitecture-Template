package de.flocksserver.androidkt_cleanarchitecture_template.ui.settings

import android.widget.Toast
import de.flocksserver.androidkt_cleanarchitecture_template.R
import de.flocksserver.androidkt_cleanarchitecture_template.base.BaseFragment
import de.flocksserver.androidkt_cleanarchitecture_template.di.components.MainComponent
import javax.inject.Inject

/**
 * Created by marcel on 24.07.17.
 */
class SettingsFragment : BaseFragment(), SettingsContract.View {

    @Inject lateinit var settingsPresenter: SettingsPresenter

    override fun getLayoutResource(): Int {
        return R.layout.fragment_settings
    }

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        settingsPresenter.resume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        settingsPresenter.destroy()
    }

    override fun initialize() {
        this.getComponent(MainComponent::class.java).inject(this)
        settingsPresenter.view = this
    }

    override fun setSettings() {
        // UI init
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}