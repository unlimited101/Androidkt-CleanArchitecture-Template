package de.flocksserver.androidkt_cleanarchitecture_template.ui.content

import android.content.Context
import de.flocksserver.androidkt_cleanarchitecture_template.R
import de.flocksserver.androidkt_cleanarchitecture_template.base.BasePresenter
import de.flocksserver.androidkt_cleanarchitecture_template.di.scope.PerFragment
import de.flocksserver.androidkt_cleanarchitecture_template.model.mapper.ContentVMMapper
import de.flocksserver.androidkt_cleanarchitecture_template.model.mapper.ItemViewMapper
import de.flocksserver.domain.exceptions.MyException
import de.flocksserver.domain.interactors.content.AddItemUseCase
import de.flocksserver.domain.interactors.content.DeleteItemUseCase
import de.flocksserver.domain.interactors.content.GetContentUseCase
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by marcel on 24.07.17.
 */
@PerFragment
class ContentPresenter @Inject constructor(
        private val getContentUseCase: GetContentUseCase,
        private val addItemUseCase: AddItemUseCase,
        private val deleteItemUseCase: DeleteItemUseCase,
        private val contentVMMapper: ContentVMMapper,
        private val itemViewMapper: ItemViewMapper
) : BasePresenter<ContentContract.View>, ContentContract.Presenter {

    override var view: ContentContract.View? = null
    @Inject lateinit var context: Context

    override fun resume() {
        updateContent()
    }

    override fun pause() {
    }

    override fun destroy() {
        getContentUseCase.dispose()
        addItemUseCase.dispose()
        deleteItemUseCase.dispose()
        view = null
    }

    override fun addItem() {
            addItemUseCase.execute(
                    Action {
                        updateContent()
                    },
                    Consumer {
                        if (it is MyException) {
                            view?.error(context.getString(R.string.error_message))
                        } else {
                            view?.error(it.message ?: "")
                        }
                    }
            )
    }

    override fun updateContent() {
        getContentUseCase.execute(
                Consumer {
                    view?.setContent(contentVMMapper.transformMtoVM(it))
                },
                Consumer {
                    if (it is MyException) {
                        view?.error(context.getString(R.string.error_message))
                    } else {
                        view?.error(it.message ?: "")
                    }
                }
        )
    }

    override fun deleteItem() {
        val item = itemViewMapper.transformVMtoM(
                view?.contentViewModel?.items?.first { it.clicked }
        )
        if (item != null) {
            deleteItemUseCase.execute(
                    Action {
                        updateContent()
                    },
                    Consumer {
                        if (it is MyException) {
                            view?.error(context.getString(R.string.error_message))
                        } else {
                            view?.error(it.message ?: "")
                        }
                    },
                    DeleteItemUseCase.Params.forItem(item)
            )
        }
    }



}