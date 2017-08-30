package de.flocksserver.androidkt_cleanarchitecture_template.model.mapper

import android.content.Context
import de.flocksserver.androidkt_cleanarchitecture_template.model.ItemView
import de.flocksserver.domain.model.ItemModel
import javax.inject.Inject

/**
 * Created by marcel on 10.08.17.
 */
class ItemViewMapper @Inject constructor(
        private val context: Context
) : BaseMapperMVM<ItemView, ItemModel>() {

    override fun transformMtoVM(model: ItemModel?): ItemView? {
        if (model != null) {
            return ItemView(context,model.name)
        }
        return null
    }

    override fun transformVMtoM(viewModel: ItemView?): ItemModel? {
        if (viewModel != null) {
            return ItemModel(viewModel.text.toString())
        }
        return null
    }
}