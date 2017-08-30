package de.flocksserver.domain.interactors.usecase

import dagger.internal.Preconditions
import de.flocksserver.domain.PostExecutionThread
import de.flocksserver.domain.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by marcel on 27.07.17.
 */
abstract class ObservableUseCaseWithParameter<T, in Params> internal constructor(private val threadExecutor: ThreadExecutor,
                                                                                 private val postExecutionThread: PostExecutionThread) : BaseUseCase() {

    internal abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params) {
        Preconditions.checkNotNull(observer)
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

}