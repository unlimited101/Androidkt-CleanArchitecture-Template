package de.flocksserver.domain.interactors.usecase

import dagger.internal.Preconditions
import de.flocksserver.domain.PostExecutionThread
import de.flocksserver.domain.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by marcel on 30.07.17.
 */
abstract class CompletableUseCaseWithParamter<in Params> internal constructor(private val threadExecutor: ThreadExecutor,
                                                                              private val postExecutionThread: PostExecutionThread) : BaseUseCase() {


    internal abstract fun buildUseCaseCompletable(params: Params): Completable

    fun execute(action: Action, error: Consumer<Throwable>, params: Params) {
        Preconditions.checkNotNull(action)
        Preconditions.checkNotNull(error)
        val observable = this.buildUseCaseCompletable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribe(action, error))
    }
}