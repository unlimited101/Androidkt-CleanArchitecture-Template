package de.flocksserver.domain.interactors.usecase.observer

import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable

/**
 * Created by marcel on 27.07.17.
 */
open class DefaultCompletable : CompletableObserver {
    override fun onComplete() {}
    override fun onSubscribe(d: Disposable) {}
    override fun onError(e: Throwable) {}
}