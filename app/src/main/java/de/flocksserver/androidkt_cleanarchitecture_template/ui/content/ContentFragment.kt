package de.flocksserver.androidkt_cleanarchitecture_template.ui.content


import android.graphics.Color
import android.view.View
import android.widget.Toast
import de.flocksserver.androidkt_cleanarchitecture_template.R
import de.flocksserver.androidkt_cleanarchitecture_template.base.BaseFragment
import de.flocksserver.androidkt_cleanarchitecture_template.di.components.MainComponent
import de.flocksserver.androidkt_cleanarchitecture_template.model.ContentViewModel
import de.flocksserver.androidkt_cleanarchitecture_template.model.ItemView
import kotlinx.android.synthetic.main.fragment_content.*
import javax.inject.Inject

/**
 * Created by marcel on 24.07.17.
 */
class ContentFragment : BaseFragment(), ContentContract.View {

    @Inject lateinit var contentPresenter: ContentPresenter

    override var contentViewModel: ContentViewModel? = null

    override fun getLayoutResource(): Int {
        return R.layout.fragment_content
    }

    companion object {
        fun newInstance(): ContentFragment {
            return ContentFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        contentPresenter.resume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        contentPresenter.destroy()
    }

    override fun initialize() {
        this.getComponent(MainComponent::class.java).inject(this)
        contentPresenter.view = this
        fab.setOnClickListener {
            contentPresenter.addItem()
        }
    }


    override fun setContent(viewModel: ContentViewModel?) {
        if (viewModel != null) {
            contentViewModel = viewModel
            progress_bar.visibility = View.GONE
            contentLayout.visibility = View.VISIBLE
            contentLayout.removeAllViews()
            contentViewModel?.items?.forEach {
                contentLayout.addView(it)
                it.setOnClickListener {
                    (it as ItemView).clicked = true
                    contentPresenter.deleteItem()
                }
            }
        }
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}