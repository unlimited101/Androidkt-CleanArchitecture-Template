package de.flocksserver.domain.interactors.content

import de.flocksserver.domain.PostExecutionThread
import de.flocksserver.domain.ThreadExecutor
import de.flocksserver.domain.interactors.usecase.CompletableUseCaseWithParamter
import de.flocksserver.domain.model.ItemModel
import de.flocksserver.domain.repository.MyRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by marcel on 02.08.17.
 */
class DeleteItemUseCase @Inject constructor(threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread,
                                            private val repository: MyRepository) :
        CompletableUseCaseWithParamter<DeleteItemUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseCompletable(params: Params): Completable {
        return this.repository.deleteItem(params.itemModel)
    }

    class Params private constructor(val itemModel: ItemModel) {
        companion object {

            fun forItem(itemModel: ItemModel): Params {
                return Params(itemModel)
            }
        }
    }

}