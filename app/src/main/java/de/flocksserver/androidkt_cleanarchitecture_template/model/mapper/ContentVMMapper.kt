package de.flocksserver.androidkt_cleanarchitecture_template.model.mapper

import de.flocksserver.androidkt_cleanarchitecture_template.model.ContentViewModel
import de.flocksserver.domain.model.ContentModel
import javax.inject.Inject

/**
 * Created by marcel on 10.08.17.
 */
class ContentVMMapper @Inject constructor(
        private val itemVMMapper: ItemViewMapper
) : BaseMapperMVM<ContentViewModel, ContentModel>() {

    override fun transformMtoVM(model: ContentModel?): ContentViewModel? {
        if (model != null) {
            return ContentViewModel(
                    itemVMMapper.transformMtoVM(model.items)
            )
        }
        return null
    }

    override fun transformVMtoM(viewModel: ContentViewModel?): ContentModel? {
        if (viewModel != null) {
            return ContentModel(
                    itemVMMapper.transformVMtoM(viewModel.items)
            )
        }
        return null
    }
}