package de.flocksserver.domain.interactors.usecase

import dagger.internal.Preconditions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by marcel on 01.08.17.
 */
abstract class BaseUseCase {

    private val disposables: CompositeDisposable = CompositeDisposable()


    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    internal fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }

}