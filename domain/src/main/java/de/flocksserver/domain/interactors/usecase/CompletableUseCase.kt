package de.flocksserver.domain.interactors.usecase

import dagger.internal.Preconditions
import de.flocksserver.domain.PostExecutionThread
import de.flocksserver.domain.ThreadExecutor
import de.flocksserver.domain.interactors.usecase.BaseUseCase
import io.reactivex.Completable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by marcel on 30.07.17.
 */
abstract class CompletableUseCase internal constructor(private val threadExecutor: ThreadExecutor,
                                                       private val postExecutionThread: PostExecutionThread) : BaseUseCase() {


    internal abstract fun buildUseCaseCompletable(): Completable

    fun execute(action: Action, error: Consumer<Throwable>) {
        Preconditions.checkNotNull(action)
        Preconditions.checkNotNull(error)
        val observable = this.buildUseCaseCompletable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribe(action, error))
    }
}