package de.flocksserver.domain.interactors.content

import de.flocksserver.domain.PostExecutionThread
import de.flocksserver.domain.ThreadExecutor
import de.flocksserver.domain.model.ContentModel
import de.flocksserver.domain.repository.MyRepository
import de.flocksserver.domain.interactors.usecase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by marcel on 27.07.17.
 */
class GetContentUseCase @Inject constructor(threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread,
                                            private val repository: MyRepository) :
        SingleUseCase<ContentModel>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(): Single<ContentModel> {
        return this.repository.getContent()
    }
}