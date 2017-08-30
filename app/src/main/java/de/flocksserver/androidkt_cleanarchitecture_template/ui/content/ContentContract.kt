package de.flocksserver.androidkt_cleanarchitecture_template.ui.content

import de.flocksserver.androidkt_cleanarchitecture_template.base.BasePresenter
import de.flocksserver.androidkt_cleanarchitecture_template.base.BaseView
import de.flocksserver.androidkt_cleanarchitecture_template.model.ContentViewModel

/**
 * Created by marcel on 24.07.17.
 */
interface ContentContract {
    interface View : BaseView {
        var contentViewModel: ContentViewModel?
        fun setContent(viewModel: ContentViewModel?)

    }
    interface Presenter : BasePresenter<View> {
        fun addItem()
        fun deleteItem()
        fun updateContent()
    }
}