package de.flocksserver.domain.interactors.usecase.observer

import io.reactivex.observers.DisposableObserver

/**
 * Created by marcel on 27.07.17.
 */
open class DefaultObserver<T> : DisposableObserver<T>() {
    override fun onNext(t: T) {}
    override fun onComplete() {}
    override fun onError(exception: Throwable) {}
}